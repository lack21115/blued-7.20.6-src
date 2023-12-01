package com.blued.im.audio_chatroom;

import com.blued.im.CommonOuterClass;
import com.blued.im.audio_chatroom.AudioCode;
import com.blued.im.audio_chatroom.AudioMsgExtra;
import com.blued.im.audio_chatroom.AudioMsgType;
import com.google.common.net.HttpHeaders;
import com.google.protobuf.AbstractMessageLite;
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
import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioChatroomOuterClass.class */
public final class AudioChatroomOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013AudioChatroom.proto\u0012\u001bcom.blued.im.audio_chatroom\u001a\u0013AudioMsgExtra.proto\u001a\u0012AudioMsgType.proto\u001a\u000fAudioCode.proto\u001a\fCommon.proto\"þ\u0002\n\u0007Request\u0012$\n\u0006common\u0018\u0001 \u0001(\u000b2\u0014.com.blued.im.Common\u0012\n\n\u0002to\u0018\u0002 \u0001(\r\u00126\n\bmsg_type\u0018\u0003 \u0001(\u000e2$.com.blued.im.audio_chatroom.MsgType\u0012\u0010\n\bcontents\u0018\u0004 \u0001(\t\u0012<\n\u000esource_profile\u0018\u0005 \u0001(\u000b2$.com.blued.im.audio_chatroom.Profile\u0012<\n\u000etarget_profile\u0018\u0006 \u0001(\u000b2$.com.blued.im.audio_chatroom.Profile\u00124\n\u0005extra\u0018\u0007 \u0001(\u000b2%.com.blued.im.audio_chatroom.MsgExtra\u0012\u000f\n\u0007room_id\u0018\b \u0001(\u0005\u0012\u0013\n\u000bsend_anyone\u0018\t \u0001(\u0005\u0012\u000e\n\u0006resend\u0018\n \u0001(\b\u0012\u000f\n\u0007members\u0018\u000b \u0003(\r\"×\u0002\n\u0007Receive\u0012\f\n\u0004from\u0018\u0001 \u0001(\r\u00126\n\bmsg_type\u0018\u0002 \u0001(\u000e2$.com.blued.im.audio_chatroom.MsgType\u0012\u0010\n\bcontents\u0018\u0003 \u0001(\t\u0012<\n\u000esource_profile\u0018\u0004 \u0001(\u000b2$.com.blued.im.audio_chatroom.Profile\u0012<\n\u000etarget_profile\u0018\u0005 \u0001(\u000b2$.com.blued.im.audio_chatroom.Profile\u00124\n\u0005extra\u0018\u0006 \u0001(\u000b2%.com.blued.im.audio_chatroom.MsgExtra\u0012\u000f\n\u0007room_id\u0018\u0007 \u0001(\u0005\u0012\u0010\n\bmsg_time\u0018\b \u0001(\u0003\u0012\u000e\n\u0006resend\u0018\t \u0001(\b\u0012\u000f\n\u0007members\u0018\n \u0003(\r\"\u008d\u0001\n\bResponse\u0012/\n\u0004code\u0018\u0001 \u0001(\u000e2!.com.blued.im.audio_chatroom.Code\u0012\u000f\n\u0007message\u0018\u0002 \u0001(\t\u0012\u0012\n\nrequest_id\u0018\u0003 \u0001(\t\u0012\u0014\n\frequest_time\u0018\u0004 \u0001(\u0003\u0012\u0015\n\rresponse_time\u0018\u0005 \u0001(\u00032f\n\rAudioChatroom\u0012U\n\u0004Send\u0012$.com.blued.im.audio_chatroom.Request\u001a%.com.blued.im.audio_chatroom.Response\"��B\u0010¢\u0002\rAudioChatroomb\u0006proto3"}, new Descriptors.FileDescriptor[]{AudioMsgExtra.getDescriptor(), AudioMsgType.getDescriptor(), AudioCode.getDescriptor(), CommonOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_com_blued_im_audio_chatroom_Receive_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_audio_chatroom_Receive_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_im_audio_chatroom_Request_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_audio_chatroom_Request_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_im_audio_chatroom_Response_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_audio_chatroom_Response_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioChatroomOuterClass$Receive.class */
    public static final class Receive extends GeneratedMessageV3 implements ReceiveOrBuilder {
        public static final int CONTENTS_FIELD_NUMBER = 3;
        public static final int EXTRA_FIELD_NUMBER = 6;
        public static final int FROM_FIELD_NUMBER = 1;
        public static final int MEMBERS_FIELD_NUMBER = 10;
        public static final int MSG_TIME_FIELD_NUMBER = 8;
        public static final int MSG_TYPE_FIELD_NUMBER = 2;
        public static final int RESEND_FIELD_NUMBER = 9;
        public static final int ROOM_ID_FIELD_NUMBER = 7;
        public static final int SOURCE_PROFILE_FIELD_NUMBER = 4;
        public static final int TARGET_PROFILE_FIELD_NUMBER = 5;
        private static final long serialVersionUID = 0;
        private volatile Object contents_;
        private AudioMsgExtra.MsgExtra extra_;
        private int from_;
        private int membersMemoizedSerializedSize;
        private Internal.IntList members_;
        private byte memoizedIsInitialized;
        private long msgTime_;
        private int msgType_;
        private boolean resend_;
        private int roomId_;
        private AudioMsgExtra.Profile sourceProfile_;
        private AudioMsgExtra.Profile targetProfile_;
        private static final Receive DEFAULT_INSTANCE = new Receive();
        private static final Parser<Receive> PARSER = new AbstractParser<Receive>() { // from class: com.blued.im.audio_chatroom.AudioChatroomOuterClass.Receive.1
            @Override // com.google.protobuf.Parser
            public Receive parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Receive(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioChatroomOuterClass$Receive$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ReceiveOrBuilder {
            private int bitField0_;
            private Object contents_;
            private SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> extraBuilder_;
            private AudioMsgExtra.MsgExtra extra_;
            private int from_;
            private Internal.IntList members_;
            private long msgTime_;
            private int msgType_;
            private boolean resend_;
            private int roomId_;
            private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> sourceProfileBuilder_;
            private AudioMsgExtra.Profile sourceProfile_;
            private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> targetProfileBuilder_;
            private AudioMsgExtra.Profile targetProfile_;

            private Builder() {
                this.msgType_ = 0;
                this.contents_ = "";
                this.members_ = Receive.access$4500();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.msgType_ = 0;
                this.contents_ = "";
                this.members_ = Receive.access$4500();
                maybeForceBuilderInitialization();
            }

            private void ensureMembersIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.members_ = Receive.mutableCopy(this.members_);
                    this.bitField0_ |= 1;
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Receive_descriptor;
            }

            private SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> getExtraFieldBuilder() {
                if (this.extraBuilder_ == null) {
                    this.extraBuilder_ = new SingleFieldBuilderV3<>(getExtra(), getParentForChildren(), isClean());
                    this.extra_ = null;
                }
                return this.extraBuilder_;
            }

            private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> getSourceProfileFieldBuilder() {
                if (this.sourceProfileBuilder_ == null) {
                    this.sourceProfileBuilder_ = new SingleFieldBuilderV3<>(getSourceProfile(), getParentForChildren(), isClean());
                    this.sourceProfile_ = null;
                }
                return this.sourceProfileBuilder_;
            }

            private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> getTargetProfileFieldBuilder() {
                if (this.targetProfileBuilder_ == null) {
                    this.targetProfileBuilder_ = new SingleFieldBuilderV3<>(getTargetProfile(), getParentForChildren(), isClean());
                    this.targetProfile_ = null;
                }
                return this.targetProfileBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Receive.alwaysUseFieldBuilders;
            }

            public Builder addAllMembers(Iterable<? extends Integer> iterable) {
                ensureMembersIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.members_);
                onChanged();
                return this;
            }

            public Builder addMembers(int i) {
                ensureMembersIsMutable();
                this.members_.addInt(i);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Receive build() {
                Receive buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Receive buildPartial() {
                Receive receive = new Receive(this);
                receive.from_ = this.from_;
                receive.msgType_ = this.msgType_;
                receive.contents_ = this.contents_;
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
                if (singleFieldBuilderV3 == null) {
                    receive.sourceProfile_ = this.sourceProfile_;
                } else {
                    receive.sourceProfile_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV32 = this.targetProfileBuilder_;
                if (singleFieldBuilderV32 == null) {
                    receive.targetProfile_ = this.targetProfile_;
                } else {
                    receive.targetProfile_ = singleFieldBuilderV32.build();
                }
                SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV33 = this.extraBuilder_;
                if (singleFieldBuilderV33 == null) {
                    receive.extra_ = this.extra_;
                } else {
                    receive.extra_ = singleFieldBuilderV33.build();
                }
                receive.roomId_ = this.roomId_;
                receive.msgTime_ = this.msgTime_;
                receive.resend_ = this.resend_;
                if ((this.bitField0_ & 1) != 0) {
                    this.members_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                receive.members_ = this.members_;
                onBuilt();
                return receive;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.from_ = 0;
                this.msgType_ = 0;
                this.contents_ = "";
                if (this.sourceProfileBuilder_ == null) {
                    this.sourceProfile_ = null;
                } else {
                    this.sourceProfile_ = null;
                    this.sourceProfileBuilder_ = null;
                }
                if (this.targetProfileBuilder_ == null) {
                    this.targetProfile_ = null;
                } else {
                    this.targetProfile_ = null;
                    this.targetProfileBuilder_ = null;
                }
                if (this.extraBuilder_ == null) {
                    this.extra_ = null;
                } else {
                    this.extra_ = null;
                    this.extraBuilder_ = null;
                }
                this.roomId_ = 0;
                this.msgTime_ = 0L;
                this.resend_ = false;
                this.members_ = Receive.access$3000();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clearContents() {
                this.contents_ = Receive.getDefaultInstance().getContents();
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

            public Builder clearFrom() {
                this.from_ = 0;
                onChanged();
                return this;
            }

            public Builder clearMembers() {
                this.members_ = Receive.access$4700();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder clearMsgTime() {
                this.msgTime_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearMsgType() {
                this.msgType_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearResend() {
                this.resend_ = false;
                onChanged();
                return this;
            }

            public Builder clearRoomId() {
                this.roomId_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSourceProfile() {
                if (this.sourceProfileBuilder_ == null) {
                    this.sourceProfile_ = null;
                    onChanged();
                    return this;
                }
                this.sourceProfile_ = null;
                this.sourceProfileBuilder_ = null;
                return this;
            }

            public Builder clearTargetProfile() {
                if (this.targetProfileBuilder_ == null) {
                    this.targetProfile_ = null;
                    onChanged();
                    return this;
                }
                this.targetProfile_ = null;
                this.targetProfileBuilder_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
            public String getContents() {
                Object obj = this.contents_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.contents_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
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
            public Receive getDefaultInstanceForType() {
                return Receive.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Receive_descriptor;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
            public AudioMsgExtra.MsgExtra getExtra() {
                SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    AudioMsgExtra.MsgExtra msgExtra = this.extra_;
                    AudioMsgExtra.MsgExtra msgExtra2 = msgExtra;
                    if (msgExtra == null) {
                        msgExtra2 = AudioMsgExtra.MsgExtra.getDefaultInstance();
                    }
                    return msgExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public AudioMsgExtra.MsgExtra.Builder getExtraBuilder() {
                onChanged();
                return getExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
            public AudioMsgExtra.MsgExtraOrBuilder getExtraOrBuilder() {
                SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                AudioMsgExtra.MsgExtra msgExtra = this.extra_;
                AudioMsgExtra.MsgExtra msgExtra2 = msgExtra;
                if (msgExtra == null) {
                    msgExtra2 = AudioMsgExtra.MsgExtra.getDefaultInstance();
                }
                return msgExtra2;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
            public int getFrom() {
                return this.from_;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
            public int getMembers(int i) {
                return this.members_.getInt(i);
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
            public int getMembersCount() {
                return this.members_.size();
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
            public List<Integer> getMembersList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.members_) : this.members_;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
            public long getMsgTime() {
                return this.msgTime_;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
            public AudioMsgType.MsgType getMsgType() {
                AudioMsgType.MsgType valueOf = AudioMsgType.MsgType.valueOf(this.msgType_);
                AudioMsgType.MsgType msgType = valueOf;
                if (valueOf == null) {
                    msgType = AudioMsgType.MsgType.UNRECOGNIZED;
                }
                return msgType;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
            public int getMsgTypeValue() {
                return this.msgType_;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
            public boolean getResend() {
                return this.resend_;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
            public int getRoomId() {
                return this.roomId_;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
            public AudioMsgExtra.Profile getSourceProfile() {
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
                if (singleFieldBuilderV3 == null) {
                    AudioMsgExtra.Profile profile = this.sourceProfile_;
                    AudioMsgExtra.Profile profile2 = profile;
                    if (profile == null) {
                        profile2 = AudioMsgExtra.Profile.getDefaultInstance();
                    }
                    return profile2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public AudioMsgExtra.Profile.Builder getSourceProfileBuilder() {
                onChanged();
                return getSourceProfileFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
            public AudioMsgExtra.ProfileOrBuilder getSourceProfileOrBuilder() {
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                AudioMsgExtra.Profile profile = this.sourceProfile_;
                AudioMsgExtra.Profile profile2 = profile;
                if (profile == null) {
                    profile2 = AudioMsgExtra.Profile.getDefaultInstance();
                }
                return profile2;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
            public AudioMsgExtra.Profile getTargetProfile() {
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
                if (singleFieldBuilderV3 == null) {
                    AudioMsgExtra.Profile profile = this.targetProfile_;
                    AudioMsgExtra.Profile profile2 = profile;
                    if (profile == null) {
                        profile2 = AudioMsgExtra.Profile.getDefaultInstance();
                    }
                    return profile2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public AudioMsgExtra.Profile.Builder getTargetProfileBuilder() {
                onChanged();
                return getTargetProfileFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
            public AudioMsgExtra.ProfileOrBuilder getTargetProfileOrBuilder() {
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                AudioMsgExtra.Profile profile = this.targetProfile_;
                AudioMsgExtra.Profile profile2 = profile;
                if (profile == null) {
                    profile2 = AudioMsgExtra.Profile.getDefaultInstance();
                }
                return profile2;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
            public boolean hasExtra() {
                return (this.extraBuilder_ == null && this.extra_ == null) ? false : true;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
            public boolean hasSourceProfile() {
                return (this.sourceProfileBuilder_ == null && this.sourceProfile_ == null) ? false : true;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
            public boolean hasTargetProfile() {
                return (this.targetProfileBuilder_ == null && this.targetProfile_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Receive_fieldAccessorTable.ensureFieldAccessorsInitialized(Receive.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeExtra(AudioMsgExtra.MsgExtra msgExtra) {
                SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(msgExtra);
                    return this;
                }
                AudioMsgExtra.MsgExtra msgExtra2 = this.extra_;
                if (msgExtra2 != null) {
                    this.extra_ = AudioMsgExtra.MsgExtra.newBuilder(msgExtra2).mergeFrom(msgExtra).buildPartial();
                } else {
                    this.extra_ = msgExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeFrom(Receive receive) {
                if (receive == Receive.getDefaultInstance()) {
                    return this;
                }
                if (receive.getFrom() != 0) {
                    setFrom(receive.getFrom());
                }
                if (receive.msgType_ != 0) {
                    setMsgTypeValue(receive.getMsgTypeValue());
                }
                if (!receive.getContents().isEmpty()) {
                    this.contents_ = receive.contents_;
                    onChanged();
                }
                if (receive.hasSourceProfile()) {
                    mergeSourceProfile(receive.getSourceProfile());
                }
                if (receive.hasTargetProfile()) {
                    mergeTargetProfile(receive.getTargetProfile());
                }
                if (receive.hasExtra()) {
                    mergeExtra(receive.getExtra());
                }
                if (receive.getRoomId() != 0) {
                    setRoomId(receive.getRoomId());
                }
                if (receive.getMsgTime() != 0) {
                    setMsgTime(receive.getMsgTime());
                }
                if (receive.getResend()) {
                    setResend(receive.getResend());
                }
                if (!receive.members_.isEmpty()) {
                    if (this.members_.isEmpty()) {
                        this.members_ = receive.members_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureMembersIsMutable();
                        this.members_.addAll(receive.members_);
                    }
                    onChanged();
                }
                mergeUnknownFields(receive.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.audio_chatroom.AudioChatroomOuterClass.Receive.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.audio_chatroom.AudioChatroomOuterClass.Receive.access$4300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.audio_chatroom.AudioChatroomOuterClass$Receive r0 = (com.blued.im.audio_chatroom.AudioChatroomOuterClass.Receive) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.audio_chatroom.AudioChatroomOuterClass$Receive$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.audio_chatroom.AudioChatroomOuterClass$Receive r0 = (com.blued.im.audio_chatroom.AudioChatroomOuterClass.Receive) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.audio_chatroom.AudioChatroomOuterClass$Receive$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.audio_chatroom.AudioChatroomOuterClass.Receive.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.audio_chatroom.AudioChatroomOuterClass$Receive$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Receive) {
                    return mergeFrom((Receive) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeSourceProfile(AudioMsgExtra.Profile profile) {
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(profile);
                    return this;
                }
                AudioMsgExtra.Profile profile2 = this.sourceProfile_;
                if (profile2 != null) {
                    this.sourceProfile_ = AudioMsgExtra.Profile.newBuilder(profile2).mergeFrom(profile).buildPartial();
                } else {
                    this.sourceProfile_ = profile;
                }
                onChanged();
                return this;
            }

            public Builder mergeTargetProfile(AudioMsgExtra.Profile profile) {
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(profile);
                    return this;
                }
                AudioMsgExtra.Profile profile2 = this.targetProfile_;
                if (profile2 != null) {
                    this.targetProfile_ = AudioMsgExtra.Profile.newBuilder(profile2).mergeFrom(profile).buildPartial();
                } else {
                    this.targetProfile_ = profile;
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
                    Receive.checkByteStringIsUtf8(byteString);
                    this.contents_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setExtra(AudioMsgExtra.MsgExtra.Builder builder) {
                SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.extra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setExtra(AudioMsgExtra.MsgExtra msgExtra) {
                SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setFrom(int i) {
                this.from_ = i;
                onChanged();
                return this;
            }

            public Builder setMembers(int i, int i2) {
                ensureMembersIsMutable();
                this.members_.setInt(i, i2);
                onChanged();
                return this;
            }

            public Builder setMsgTime(long j) {
                this.msgTime_ = j;
                onChanged();
                return this;
            }

            public Builder setMsgType(AudioMsgType.MsgType msgType) {
                if (msgType != null) {
                    this.msgType_ = msgType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMsgTypeValue(int i) {
                this.msgType_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setResend(boolean z) {
                this.resend_ = z;
                onChanged();
                return this;
            }

            public Builder setRoomId(int i) {
                this.roomId_ = i;
                onChanged();
                return this;
            }

            public Builder setSourceProfile(AudioMsgExtra.Profile.Builder builder) {
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.sourceProfile_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setSourceProfile(AudioMsgExtra.Profile profile) {
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(profile);
                    return this;
                } else if (profile != null) {
                    this.sourceProfile_ = profile;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setTargetProfile(AudioMsgExtra.Profile.Builder builder) {
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.targetProfile_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setTargetProfile(AudioMsgExtra.Profile profile) {
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(profile);
                    return this;
                } else if (profile != null) {
                    this.targetProfile_ = profile;
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
        }

        private Receive() {
            this.membersMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.msgType_ = 0;
            this.contents_ = "";
            this.members_ = emptyIntList();
        }

        private Receive(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            AudioMsgExtra.Profile.Builder builder;
            AudioMsgExtra.Profile.Builder builder2;
            AudioMsgExtra.MsgExtra.Builder builder3;
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
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    this.from_ = codedInputStream.readUInt32();
                                    continue;
                                case 16:
                                    this.msgType_ = codedInputStream.readEnum();
                                    continue;
                                case 26:
                                    this.contents_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 34:
                                    if (this.sourceProfile_ != null) {
                                        boolean z4 = z2;
                                        builder = this.sourceProfile_.toBuilder();
                                    } else {
                                        builder = null;
                                    }
                                    AudioMsgExtra.Profile profile = (AudioMsgExtra.Profile) codedInputStream.readMessage(AudioMsgExtra.Profile.parser(), extensionRegistryLite);
                                    boolean z5 = z2;
                                    this.sourceProfile_ = profile;
                                    if (builder != null) {
                                        builder.mergeFrom(profile);
                                        boolean z6 = z2;
                                        this.sourceProfile_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 42:
                                    if (this.targetProfile_ != null) {
                                        boolean z7 = z2;
                                        builder2 = this.targetProfile_.toBuilder();
                                    } else {
                                        builder2 = null;
                                    }
                                    AudioMsgExtra.Profile profile2 = (AudioMsgExtra.Profile) codedInputStream.readMessage(AudioMsgExtra.Profile.parser(), extensionRegistryLite);
                                    boolean z8 = z2;
                                    this.targetProfile_ = profile2;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(profile2);
                                        boolean z9 = z2;
                                        this.targetProfile_ = builder2.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 50:
                                    if (this.extra_ != null) {
                                        boolean z10 = z2;
                                        builder3 = this.extra_.toBuilder();
                                    } else {
                                        builder3 = null;
                                    }
                                    AudioMsgExtra.MsgExtra msgExtra = (AudioMsgExtra.MsgExtra) codedInputStream.readMessage(AudioMsgExtra.MsgExtra.parser(), extensionRegistryLite);
                                    boolean z11 = z2;
                                    this.extra_ = msgExtra;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(msgExtra);
                                        boolean z12 = z2;
                                        this.extra_ = builder3.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 56:
                                    this.roomId_ = codedInputStream.readInt32();
                                    continue;
                                case 64:
                                    this.msgTime_ = codedInputStream.readInt64();
                                    continue;
                                case 72:
                                    this.resend_ = codedInputStream.readBool();
                                    continue;
                                case 80:
                                    boolean z13 = z2;
                                    if (!(z2 & true)) {
                                        this.members_ = newIntList();
                                        z13 = z2 | true;
                                    }
                                    this.members_.addInt(codedInputStream.readUInt32());
                                    z2 = z13;
                                    continue;
                                case 82:
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    boolean z14 = z2;
                                    if (!(z2 & true)) {
                                        z14 = z2;
                                        if (codedInputStream.getBytesUntilLimit() > 0) {
                                            boolean z15 = z2;
                                            this.members_ = newIntList();
                                            z14 = z2 | true;
                                        }
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        boolean z16 = z14;
                                        this.members_.addInt(codedInputStream.readUInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                    z2 = z14;
                                    continue;
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
                } catch (Throwable th) {
                    if (z3 & true) {
                        this.members_.makeImmutable();
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.members_.makeImmutable();
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }

        private Receive(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.membersMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        static /* synthetic */ Internal.IntList access$3000() {
            return emptyIntList();
        }

        static /* synthetic */ Internal.IntList access$4500() {
            return emptyIntList();
        }

        static /* synthetic */ Internal.IntList access$4700() {
            return emptyIntList();
        }

        public static Receive getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Receive_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Receive receive) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(receive);
        }

        public static Receive parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Receive) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Receive parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Receive) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Receive parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Receive parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Receive parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Receive) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Receive parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Receive) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Receive parseFrom(InputStream inputStream) throws IOException {
            return (Receive) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Receive parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Receive) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Receive parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Receive parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Receive parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Receive parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Receive> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Receive) {
                Receive receive = (Receive) obj;
                if (getFrom() == receive.getFrom() && this.msgType_ == receive.msgType_ && getContents().equals(receive.getContents()) && hasSourceProfile() == receive.hasSourceProfile()) {
                    if ((!hasSourceProfile() || getSourceProfile().equals(receive.getSourceProfile())) && hasTargetProfile() == receive.hasTargetProfile()) {
                        if ((!hasTargetProfile() || getTargetProfile().equals(receive.getTargetProfile())) && hasExtra() == receive.hasExtra()) {
                            return (!hasExtra() || getExtra().equals(receive.getExtra())) && getRoomId() == receive.getRoomId() && getMsgTime() == receive.getMsgTime() && getResend() == receive.getResend() && getMembersList().equals(receive.getMembersList()) && this.unknownFields.equals(receive.unknownFields);
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
        public String getContents() {
            Object obj = this.contents_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.contents_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
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
        public Receive getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
        public AudioMsgExtra.MsgExtra getExtra() {
            AudioMsgExtra.MsgExtra msgExtra = this.extra_;
            AudioMsgExtra.MsgExtra msgExtra2 = msgExtra;
            if (msgExtra == null) {
                msgExtra2 = AudioMsgExtra.MsgExtra.getDefaultInstance();
            }
            return msgExtra2;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
        public AudioMsgExtra.MsgExtraOrBuilder getExtraOrBuilder() {
            return getExtra();
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
        public int getFrom() {
            return this.from_;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
        public int getMembers(int i) {
            return this.members_.getInt(i);
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
        public int getMembersCount() {
            return this.members_.size();
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
        public List<Integer> getMembersList() {
            return this.members_;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
        public long getMsgTime() {
            return this.msgTime_;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
        public AudioMsgType.MsgType getMsgType() {
            AudioMsgType.MsgType valueOf = AudioMsgType.MsgType.valueOf(this.msgType_);
            AudioMsgType.MsgType msgType = valueOf;
            if (valueOf == null) {
                msgType = AudioMsgType.MsgType.UNRECOGNIZED;
            }
            return msgType;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
        public int getMsgTypeValue() {
            return this.msgType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Receive> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
        public boolean getResend() {
            return this.resend_;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
        public int getRoomId() {
            return this.roomId_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.from_;
            int computeUInt32Size = i2 != 0 ? CodedOutputStream.computeUInt32Size(1, i2) + 0 : 0;
            int i3 = computeUInt32Size;
            if (this.msgType_ != AudioMsgType.MsgType.UNKNOWN_MSG_TYPE.getNumber()) {
                i3 = computeUInt32Size + CodedOutputStream.computeEnumSize(2, this.msgType_);
            }
            int i4 = i3;
            if (!getContentsBytes().isEmpty()) {
                i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.contents_);
            }
            int i5 = i4;
            if (this.sourceProfile_ != null) {
                i5 = i4 + CodedOutputStream.computeMessageSize(4, getSourceProfile());
            }
            int i6 = i5;
            if (this.targetProfile_ != null) {
                i6 = i5 + CodedOutputStream.computeMessageSize(5, getTargetProfile());
            }
            int i7 = i6;
            if (this.extra_ != null) {
                i7 = i6 + CodedOutputStream.computeMessageSize(6, getExtra());
            }
            int i8 = this.roomId_;
            int i9 = i7;
            if (i8 != 0) {
                i9 = i7 + CodedOutputStream.computeInt32Size(7, i8);
            }
            long j = this.msgTime_;
            int i10 = i9;
            if (j != 0) {
                i10 = i9 + CodedOutputStream.computeInt64Size(8, j);
            }
            boolean z = this.resend_;
            int i11 = i10;
            if (z) {
                i11 = i10 + CodedOutputStream.computeBoolSize(9, z);
            }
            int i12 = 0;
            for (int i13 = 0; i13 < this.members_.size(); i13++) {
                i12 += CodedOutputStream.computeUInt32SizeNoTag(this.members_.getInt(i13));
            }
            int i14 = i11 + i12;
            int i15 = i14;
            if (!getMembersList().isEmpty()) {
                i15 = i14 + 1 + CodedOutputStream.computeInt32SizeNoTag(i12);
            }
            this.membersMemoizedSerializedSize = i12;
            int serializedSize = i15 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
        public AudioMsgExtra.Profile getSourceProfile() {
            AudioMsgExtra.Profile profile = this.sourceProfile_;
            AudioMsgExtra.Profile profile2 = profile;
            if (profile == null) {
                profile2 = AudioMsgExtra.Profile.getDefaultInstance();
            }
            return profile2;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
        public AudioMsgExtra.ProfileOrBuilder getSourceProfileOrBuilder() {
            return getSourceProfile();
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
        public AudioMsgExtra.Profile getTargetProfile() {
            AudioMsgExtra.Profile profile = this.targetProfile_;
            AudioMsgExtra.Profile profile2 = profile;
            if (profile == null) {
                profile2 = AudioMsgExtra.Profile.getDefaultInstance();
            }
            return profile2;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
        public AudioMsgExtra.ProfileOrBuilder getTargetProfileOrBuilder() {
            return getTargetProfile();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
        public boolean hasExtra() {
            return this.extra_ != null;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
        public boolean hasSourceProfile() {
            return this.sourceProfile_ != null;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ReceiveOrBuilder
        public boolean hasTargetProfile() {
            return this.targetProfile_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getFrom()) * 37) + 2) * 53) + this.msgType_) * 37) + 3) * 53) + getContents().hashCode();
            int i = hashCode;
            if (hasSourceProfile()) {
                i = (((hashCode * 37) + 4) * 53) + getSourceProfile().hashCode();
            }
            int i2 = i;
            if (hasTargetProfile()) {
                i2 = (((i * 37) + 5) * 53) + getTargetProfile().hashCode();
            }
            int i3 = i2;
            if (hasExtra()) {
                i3 = (((i2 * 37) + 6) * 53) + getExtra().hashCode();
            }
            int roomId = (((((((((((i3 * 37) + 7) * 53) + getRoomId()) * 37) + 8) * 53) + Internal.hashLong(getMsgTime())) * 37) + 9) * 53) + Internal.hashBoolean(getResend());
            int i4 = roomId;
            if (getMembersCount() > 0) {
                i4 = (((roomId * 37) + 10) * 53) + getMembersList().hashCode();
            }
            int hashCode2 = (i4 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Receive_fieldAccessorTable.ensureFieldAccessorsInitialized(Receive.class, Builder.class);
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
            return new Receive();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            int i = this.from_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            if (this.msgType_ != AudioMsgType.MsgType.UNKNOWN_MSG_TYPE.getNumber()) {
                codedOutputStream.writeEnum(2, this.msgType_);
            }
            if (!getContentsBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.contents_);
            }
            if (this.sourceProfile_ != null) {
                codedOutputStream.writeMessage(4, getSourceProfile());
            }
            if (this.targetProfile_ != null) {
                codedOutputStream.writeMessage(5, getTargetProfile());
            }
            if (this.extra_ != null) {
                codedOutputStream.writeMessage(6, getExtra());
            }
            int i2 = this.roomId_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(7, i2);
            }
            long j = this.msgTime_;
            if (j != 0) {
                codedOutputStream.writeInt64(8, j);
            }
            boolean z = this.resend_;
            if (z) {
                codedOutputStream.writeBool(9, z);
            }
            if (getMembersList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(82);
                codedOutputStream.writeUInt32NoTag(this.membersMemoizedSerializedSize);
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.members_.size()) {
                    this.unknownFields.writeTo(codedOutputStream);
                    return;
                } else {
                    codedOutputStream.writeUInt32NoTag(this.members_.getInt(i4));
                    i3 = i4 + 1;
                }
            }
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioChatroomOuterClass$ReceiveOrBuilder.class */
    public interface ReceiveOrBuilder extends MessageOrBuilder {
        String getContents();

        ByteString getContentsBytes();

        AudioMsgExtra.MsgExtra getExtra();

        AudioMsgExtra.MsgExtraOrBuilder getExtraOrBuilder();

        int getFrom();

        int getMembers(int i);

        int getMembersCount();

        List<Integer> getMembersList();

        long getMsgTime();

        AudioMsgType.MsgType getMsgType();

        int getMsgTypeValue();

        boolean getResend();

        int getRoomId();

        AudioMsgExtra.Profile getSourceProfile();

        AudioMsgExtra.ProfileOrBuilder getSourceProfileOrBuilder();

        AudioMsgExtra.Profile getTargetProfile();

        AudioMsgExtra.ProfileOrBuilder getTargetProfileOrBuilder();

        boolean hasExtra();

        boolean hasSourceProfile();

        boolean hasTargetProfile();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioChatroomOuterClass$Request.class */
    public static final class Request extends GeneratedMessageV3 implements RequestOrBuilder {
        public static final int COMMON_FIELD_NUMBER = 1;
        public static final int CONTENTS_FIELD_NUMBER = 4;
        public static final int EXTRA_FIELD_NUMBER = 7;
        public static final int MEMBERS_FIELD_NUMBER = 11;
        public static final int MSG_TYPE_FIELD_NUMBER = 3;
        public static final int RESEND_FIELD_NUMBER = 10;
        public static final int ROOM_ID_FIELD_NUMBER = 8;
        public static final int SEND_ANYONE_FIELD_NUMBER = 9;
        public static final int SOURCE_PROFILE_FIELD_NUMBER = 5;
        public static final int TARGET_PROFILE_FIELD_NUMBER = 6;
        public static final int TO_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private CommonOuterClass.Common common_;
        private volatile Object contents_;
        private AudioMsgExtra.MsgExtra extra_;
        private int membersMemoizedSerializedSize;
        private Internal.IntList members_;
        private byte memoizedIsInitialized;
        private int msgType_;
        private boolean resend_;
        private int roomId_;
        private int sendAnyone_;
        private AudioMsgExtra.Profile sourceProfile_;
        private AudioMsgExtra.Profile targetProfile_;
        private int to_;
        private static final Request DEFAULT_INSTANCE = new Request();
        private static final Parser<Request> PARSER = new AbstractParser<Request>() { // from class: com.blued.im.audio_chatroom.AudioChatroomOuterClass.Request.1
            @Override // com.google.protobuf.Parser
            public Request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Request(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioChatroomOuterClass$Request$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RequestOrBuilder {
            private int bitField0_;
            private SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> commonBuilder_;
            private CommonOuterClass.Common common_;
            private Object contents_;
            private SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> extraBuilder_;
            private AudioMsgExtra.MsgExtra extra_;
            private Internal.IntList members_;
            private int msgType_;
            private boolean resend_;
            private int roomId_;
            private int sendAnyone_;
            private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> sourceProfileBuilder_;
            private AudioMsgExtra.Profile sourceProfile_;
            private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> targetProfileBuilder_;
            private AudioMsgExtra.Profile targetProfile_;
            private int to_;

            private Builder() {
                this.msgType_ = 0;
                this.contents_ = "";
                this.members_ = Request.access$2100();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.msgType_ = 0;
                this.contents_ = "";
                this.members_ = Request.access$2100();
                maybeForceBuilderInitialization();
            }

            private void ensureMembersIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.members_ = Request.mutableCopy(this.members_);
                    this.bitField0_ |= 1;
                }
            }

            private SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> getCommonFieldBuilder() {
                if (this.commonBuilder_ == null) {
                    this.commonBuilder_ = new SingleFieldBuilderV3<>(getCommon(), getParentForChildren(), isClean());
                    this.common_ = null;
                }
                return this.commonBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Request_descriptor;
            }

            private SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> getExtraFieldBuilder() {
                if (this.extraBuilder_ == null) {
                    this.extraBuilder_ = new SingleFieldBuilderV3<>(getExtra(), getParentForChildren(), isClean());
                    this.extra_ = null;
                }
                return this.extraBuilder_;
            }

            private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> getSourceProfileFieldBuilder() {
                if (this.sourceProfileBuilder_ == null) {
                    this.sourceProfileBuilder_ = new SingleFieldBuilderV3<>(getSourceProfile(), getParentForChildren(), isClean());
                    this.sourceProfile_ = null;
                }
                return this.sourceProfileBuilder_;
            }

            private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> getTargetProfileFieldBuilder() {
                if (this.targetProfileBuilder_ == null) {
                    this.targetProfileBuilder_ = new SingleFieldBuilderV3<>(getTargetProfile(), getParentForChildren(), isClean());
                    this.targetProfile_ = null;
                }
                return this.targetProfileBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Request.alwaysUseFieldBuilders;
            }

            public Builder addAllMembers(Iterable<? extends Integer> iterable) {
                ensureMembersIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.members_);
                onChanged();
                return this;
            }

            public Builder addMembers(int i) {
                ensureMembersIsMutable();
                this.members_.addInt(i);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Request build() {
                Request buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Request buildPartial() {
                Request request = new Request(this);
                SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    request.common_ = this.common_;
                } else {
                    request.common_ = singleFieldBuilderV3.build();
                }
                request.to_ = this.to_;
                request.msgType_ = this.msgType_;
                request.contents_ = this.contents_;
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV32 = this.sourceProfileBuilder_;
                if (singleFieldBuilderV32 == null) {
                    request.sourceProfile_ = this.sourceProfile_;
                } else {
                    request.sourceProfile_ = singleFieldBuilderV32.build();
                }
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV33 = this.targetProfileBuilder_;
                if (singleFieldBuilderV33 == null) {
                    request.targetProfile_ = this.targetProfile_;
                } else {
                    request.targetProfile_ = singleFieldBuilderV33.build();
                }
                SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV34 = this.extraBuilder_;
                if (singleFieldBuilderV34 == null) {
                    request.extra_ = this.extra_;
                } else {
                    request.extra_ = singleFieldBuilderV34.build();
                }
                request.roomId_ = this.roomId_;
                request.sendAnyone_ = this.sendAnyone_;
                request.resend_ = this.resend_;
                if ((this.bitField0_ & 1) != 0) {
                    this.members_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                request.members_ = this.members_;
                onBuilt();
                return request;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.commonBuilder_ == null) {
                    this.common_ = null;
                } else {
                    this.common_ = null;
                    this.commonBuilder_ = null;
                }
                this.to_ = 0;
                this.msgType_ = 0;
                this.contents_ = "";
                if (this.sourceProfileBuilder_ == null) {
                    this.sourceProfile_ = null;
                } else {
                    this.sourceProfile_ = null;
                    this.sourceProfileBuilder_ = null;
                }
                if (this.targetProfileBuilder_ == null) {
                    this.targetProfile_ = null;
                } else {
                    this.targetProfile_ = null;
                    this.targetProfileBuilder_ = null;
                }
                if (this.extraBuilder_ == null) {
                    this.extra_ = null;
                } else {
                    this.extra_ = null;
                    this.extraBuilder_ = null;
                }
                this.roomId_ = 0;
                this.sendAnyone_ = 0;
                this.resend_ = false;
                this.members_ = Request.access$500();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clearCommon() {
                if (this.commonBuilder_ == null) {
                    this.common_ = null;
                    onChanged();
                    return this;
                }
                this.common_ = null;
                this.commonBuilder_ = null;
                return this;
            }

            public Builder clearContents() {
                this.contents_ = Request.getDefaultInstance().getContents();
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

            public Builder clearMembers() {
                this.members_ = Request.access$2300();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder clearMsgType() {
                this.msgType_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearResend() {
                this.resend_ = false;
                onChanged();
                return this;
            }

            public Builder clearRoomId() {
                this.roomId_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSendAnyone() {
                this.sendAnyone_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSourceProfile() {
                if (this.sourceProfileBuilder_ == null) {
                    this.sourceProfile_ = null;
                    onChanged();
                    return this;
                }
                this.sourceProfile_ = null;
                this.sourceProfileBuilder_ = null;
                return this;
            }

            public Builder clearTargetProfile() {
                if (this.targetProfileBuilder_ == null) {
                    this.targetProfile_ = null;
                    onChanged();
                    return this;
                }
                this.targetProfile_ = null;
                this.targetProfileBuilder_ = null;
                return this;
            }

            public Builder clearTo() {
                this.to_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public CommonOuterClass.Common getCommon() {
                SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    CommonOuterClass.Common common = this.common_;
                    CommonOuterClass.Common common2 = common;
                    if (common == null) {
                        common2 = CommonOuterClass.Common.getDefaultInstance();
                    }
                    return common2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public CommonOuterClass.Common.Builder getCommonBuilder() {
                onChanged();
                return getCommonFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public CommonOuterClass.CommonOrBuilder getCommonOrBuilder() {
                SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                CommonOuterClass.Common common = this.common_;
                CommonOuterClass.Common common2 = common;
                if (common == null) {
                    common2 = CommonOuterClass.Common.getDefaultInstance();
                }
                return common2;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public String getContents() {
                Object obj = this.contents_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.contents_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
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
            public Request getDefaultInstanceForType() {
                return Request.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Request_descriptor;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public AudioMsgExtra.MsgExtra getExtra() {
                SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    AudioMsgExtra.MsgExtra msgExtra = this.extra_;
                    AudioMsgExtra.MsgExtra msgExtra2 = msgExtra;
                    if (msgExtra == null) {
                        msgExtra2 = AudioMsgExtra.MsgExtra.getDefaultInstance();
                    }
                    return msgExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public AudioMsgExtra.MsgExtra.Builder getExtraBuilder() {
                onChanged();
                return getExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public AudioMsgExtra.MsgExtraOrBuilder getExtraOrBuilder() {
                SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                AudioMsgExtra.MsgExtra msgExtra = this.extra_;
                AudioMsgExtra.MsgExtra msgExtra2 = msgExtra;
                if (msgExtra == null) {
                    msgExtra2 = AudioMsgExtra.MsgExtra.getDefaultInstance();
                }
                return msgExtra2;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public int getMembers(int i) {
                return this.members_.getInt(i);
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public int getMembersCount() {
                return this.members_.size();
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public List<Integer> getMembersList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.members_) : this.members_;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public AudioMsgType.MsgType getMsgType() {
                AudioMsgType.MsgType valueOf = AudioMsgType.MsgType.valueOf(this.msgType_);
                AudioMsgType.MsgType msgType = valueOf;
                if (valueOf == null) {
                    msgType = AudioMsgType.MsgType.UNRECOGNIZED;
                }
                return msgType;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public int getMsgTypeValue() {
                return this.msgType_;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public boolean getResend() {
                return this.resend_;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public int getRoomId() {
                return this.roomId_;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public int getSendAnyone() {
                return this.sendAnyone_;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public AudioMsgExtra.Profile getSourceProfile() {
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
                if (singleFieldBuilderV3 == null) {
                    AudioMsgExtra.Profile profile = this.sourceProfile_;
                    AudioMsgExtra.Profile profile2 = profile;
                    if (profile == null) {
                        profile2 = AudioMsgExtra.Profile.getDefaultInstance();
                    }
                    return profile2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public AudioMsgExtra.Profile.Builder getSourceProfileBuilder() {
                onChanged();
                return getSourceProfileFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public AudioMsgExtra.ProfileOrBuilder getSourceProfileOrBuilder() {
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                AudioMsgExtra.Profile profile = this.sourceProfile_;
                AudioMsgExtra.Profile profile2 = profile;
                if (profile == null) {
                    profile2 = AudioMsgExtra.Profile.getDefaultInstance();
                }
                return profile2;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public AudioMsgExtra.Profile getTargetProfile() {
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
                if (singleFieldBuilderV3 == null) {
                    AudioMsgExtra.Profile profile = this.targetProfile_;
                    AudioMsgExtra.Profile profile2 = profile;
                    if (profile == null) {
                        profile2 = AudioMsgExtra.Profile.getDefaultInstance();
                    }
                    return profile2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public AudioMsgExtra.Profile.Builder getTargetProfileBuilder() {
                onChanged();
                return getTargetProfileFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public AudioMsgExtra.ProfileOrBuilder getTargetProfileOrBuilder() {
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                AudioMsgExtra.Profile profile = this.targetProfile_;
                AudioMsgExtra.Profile profile2 = profile;
                if (profile == null) {
                    profile2 = AudioMsgExtra.Profile.getDefaultInstance();
                }
                return profile2;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public int getTo() {
                return this.to_;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public boolean hasCommon() {
                return (this.commonBuilder_ == null && this.common_ == null) ? false : true;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public boolean hasExtra() {
                return (this.extraBuilder_ == null && this.extra_ == null) ? false : true;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public boolean hasSourceProfile() {
                return (this.sourceProfileBuilder_ == null && this.sourceProfile_ == null) ? false : true;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
            public boolean hasTargetProfile() {
                return (this.targetProfileBuilder_ == null && this.targetProfile_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeCommon(CommonOuterClass.Common common) {
                SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(common);
                    return this;
                }
                CommonOuterClass.Common common2 = this.common_;
                if (common2 != null) {
                    this.common_ = CommonOuterClass.Common.newBuilder(common2).mergeFrom(common).buildPartial();
                } else {
                    this.common_ = common;
                }
                onChanged();
                return this;
            }

            public Builder mergeExtra(AudioMsgExtra.MsgExtra msgExtra) {
                SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(msgExtra);
                    return this;
                }
                AudioMsgExtra.MsgExtra msgExtra2 = this.extra_;
                if (msgExtra2 != null) {
                    this.extra_ = AudioMsgExtra.MsgExtra.newBuilder(msgExtra2).mergeFrom(msgExtra).buildPartial();
                } else {
                    this.extra_ = msgExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeFrom(Request request) {
                if (request == Request.getDefaultInstance()) {
                    return this;
                }
                if (request.hasCommon()) {
                    mergeCommon(request.getCommon());
                }
                if (request.getTo() != 0) {
                    setTo(request.getTo());
                }
                if (request.msgType_ != 0) {
                    setMsgTypeValue(request.getMsgTypeValue());
                }
                if (!request.getContents().isEmpty()) {
                    this.contents_ = request.contents_;
                    onChanged();
                }
                if (request.hasSourceProfile()) {
                    mergeSourceProfile(request.getSourceProfile());
                }
                if (request.hasTargetProfile()) {
                    mergeTargetProfile(request.getTargetProfile());
                }
                if (request.hasExtra()) {
                    mergeExtra(request.getExtra());
                }
                if (request.getRoomId() != 0) {
                    setRoomId(request.getRoomId());
                }
                if (request.getSendAnyone() != 0) {
                    setSendAnyone(request.getSendAnyone());
                }
                if (request.getResend()) {
                    setResend(request.getResend());
                }
                if (!request.members_.isEmpty()) {
                    if (this.members_.isEmpty()) {
                        this.members_ = request.members_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureMembersIsMutable();
                        this.members_.addAll(request.members_);
                    }
                    onChanged();
                }
                mergeUnknownFields(request.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.audio_chatroom.AudioChatroomOuterClass.Request.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.audio_chatroom.AudioChatroomOuterClass.Request.access$1900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.audio_chatroom.AudioChatroomOuterClass$Request r0 = (com.blued.im.audio_chatroom.AudioChatroomOuterClass.Request) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.audio_chatroom.AudioChatroomOuterClass$Request$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.audio_chatroom.AudioChatroomOuterClass$Request r0 = (com.blued.im.audio_chatroom.AudioChatroomOuterClass.Request) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.audio_chatroom.AudioChatroomOuterClass$Request$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.audio_chatroom.AudioChatroomOuterClass.Request.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.audio_chatroom.AudioChatroomOuterClass$Request$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Request) {
                    return mergeFrom((Request) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeSourceProfile(AudioMsgExtra.Profile profile) {
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(profile);
                    return this;
                }
                AudioMsgExtra.Profile profile2 = this.sourceProfile_;
                if (profile2 != null) {
                    this.sourceProfile_ = AudioMsgExtra.Profile.newBuilder(profile2).mergeFrom(profile).buildPartial();
                } else {
                    this.sourceProfile_ = profile;
                }
                onChanged();
                return this;
            }

            public Builder mergeTargetProfile(AudioMsgExtra.Profile profile) {
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(profile);
                    return this;
                }
                AudioMsgExtra.Profile profile2 = this.targetProfile_;
                if (profile2 != null) {
                    this.targetProfile_ = AudioMsgExtra.Profile.newBuilder(profile2).mergeFrom(profile).buildPartial();
                } else {
                    this.targetProfile_ = profile;
                }
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setCommon(CommonOuterClass.Common.Builder builder) {
                SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.common_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setCommon(CommonOuterClass.Common common) {
                SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(common);
                    return this;
                } else if (common != null) {
                    this.common_ = common;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
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
                    Request.checkByteStringIsUtf8(byteString);
                    this.contents_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setExtra(AudioMsgExtra.MsgExtra.Builder builder) {
                SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.extra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setExtra(AudioMsgExtra.MsgExtra msgExtra) {
                SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setMembers(int i, int i2) {
                ensureMembersIsMutable();
                this.members_.setInt(i, i2);
                onChanged();
                return this;
            }

            public Builder setMsgType(AudioMsgType.MsgType msgType) {
                if (msgType != null) {
                    this.msgType_ = msgType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMsgTypeValue(int i) {
                this.msgType_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setResend(boolean z) {
                this.resend_ = z;
                onChanged();
                return this;
            }

            public Builder setRoomId(int i) {
                this.roomId_ = i;
                onChanged();
                return this;
            }

            public Builder setSendAnyone(int i) {
                this.sendAnyone_ = i;
                onChanged();
                return this;
            }

            public Builder setSourceProfile(AudioMsgExtra.Profile.Builder builder) {
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.sourceProfile_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setSourceProfile(AudioMsgExtra.Profile profile) {
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(profile);
                    return this;
                } else if (profile != null) {
                    this.sourceProfile_ = profile;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setTargetProfile(AudioMsgExtra.Profile.Builder builder) {
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.targetProfile_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setTargetProfile(AudioMsgExtra.Profile profile) {
                SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(profile);
                    return this;
                } else if (profile != null) {
                    this.targetProfile_ = profile;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setTo(int i) {
                this.to_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private Request() {
            this.membersMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.msgType_ = 0;
            this.contents_ = "";
            this.members_ = emptyIntList();
        }

        private Request(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            CommonOuterClass.Common.Builder builder;
            AudioMsgExtra.Profile.Builder builder2;
            AudioMsgExtra.Profile.Builder builder3;
            AudioMsgExtra.MsgExtra.Builder builder4;
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
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                if (this.common_ != null) {
                                    boolean z4 = z2;
                                    builder = this.common_.toBuilder();
                                } else {
                                    builder = null;
                                }
                                CommonOuterClass.Common common = (CommonOuterClass.Common) codedInputStream.readMessage(CommonOuterClass.Common.parser(), extensionRegistryLite);
                                boolean z5 = z2;
                                this.common_ = common;
                                if (builder != null) {
                                    builder.mergeFrom(common);
                                    boolean z6 = z2;
                                    this.common_ = builder.buildPartial();
                                } else {
                                    continue;
                                }
                            case 16:
                                this.to_ = codedInputStream.readUInt32();
                                continue;
                            case 24:
                                this.msgType_ = codedInputStream.readEnum();
                                continue;
                            case 34:
                                this.contents_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 42:
                                if (this.sourceProfile_ != null) {
                                    boolean z7 = z2;
                                    builder2 = this.sourceProfile_.toBuilder();
                                } else {
                                    builder2 = null;
                                }
                                AudioMsgExtra.Profile profile = (AudioMsgExtra.Profile) codedInputStream.readMessage(AudioMsgExtra.Profile.parser(), extensionRegistryLite);
                                boolean z8 = z2;
                                this.sourceProfile_ = profile;
                                if (builder2 != null) {
                                    builder2.mergeFrom(profile);
                                    boolean z9 = z2;
                                    this.sourceProfile_ = builder2.buildPartial();
                                } else {
                                    continue;
                                }
                            case 50:
                                if (this.targetProfile_ != null) {
                                    boolean z10 = z2;
                                    builder3 = this.targetProfile_.toBuilder();
                                } else {
                                    builder3 = null;
                                }
                                AudioMsgExtra.Profile profile2 = (AudioMsgExtra.Profile) codedInputStream.readMessage(AudioMsgExtra.Profile.parser(), extensionRegistryLite);
                                boolean z11 = z2;
                                this.targetProfile_ = profile2;
                                if (builder3 != null) {
                                    builder3.mergeFrom(profile2);
                                    boolean z12 = z2;
                                    this.targetProfile_ = builder3.buildPartial();
                                } else {
                                    continue;
                                }
                            case 58:
                                if (this.extra_ != null) {
                                    boolean z13 = z2;
                                    builder4 = this.extra_.toBuilder();
                                } else {
                                    builder4 = null;
                                }
                                AudioMsgExtra.MsgExtra msgExtra = (AudioMsgExtra.MsgExtra) codedInputStream.readMessage(AudioMsgExtra.MsgExtra.parser(), extensionRegistryLite);
                                boolean z14 = z2;
                                this.extra_ = msgExtra;
                                if (builder4 != null) {
                                    builder4.mergeFrom(msgExtra);
                                    boolean z15 = z2;
                                    this.extra_ = builder4.buildPartial();
                                } else {
                                    continue;
                                }
                            case 64:
                                this.roomId_ = codedInputStream.readInt32();
                                continue;
                            case 72:
                                this.sendAnyone_ = codedInputStream.readInt32();
                                continue;
                            case 80:
                                this.resend_ = codedInputStream.readBool();
                                continue;
                            case 88:
                                boolean z16 = z2;
                                if (!(z2 & true)) {
                                    this.members_ = newIntList();
                                    z16 = z2 | true;
                                }
                                this.members_.addInt(codedInputStream.readUInt32());
                                z2 = z16;
                                continue;
                            case 90:
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                boolean z17 = z2;
                                if (!(z2 & true)) {
                                    z17 = z2;
                                    if (codedInputStream.getBytesUntilLimit() > 0) {
                                        boolean z18 = z2;
                                        this.members_ = newIntList();
                                        z17 = z2 | true;
                                    }
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    boolean z19 = z17;
                                    this.members_.addInt(codedInputStream.readUInt32());
                                }
                                codedInputStream.popLimit(pushLimit);
                                z2 = z17;
                                continue;
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
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z3 & true) {
                        this.members_.makeImmutable();
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.members_.makeImmutable();
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }

        private Request(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.membersMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        static /* synthetic */ Internal.IntList access$2100() {
            return emptyIntList();
        }

        static /* synthetic */ Internal.IntList access$2300() {
            return emptyIntList();
        }

        static /* synthetic */ Internal.IntList access$500() {
            return emptyIntList();
        }

        public static Request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Request_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Request request) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(request);
        }

        public static Request parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Request parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Request parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Request parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Request parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Request parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Request parseFrom(InputStream inputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Request parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Request parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Request parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Request parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Request parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Request> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Request) {
                Request request = (Request) obj;
                if (hasCommon() != request.hasCommon()) {
                    return false;
                }
                if ((!hasCommon() || getCommon().equals(request.getCommon())) && getTo() == request.getTo() && this.msgType_ == request.msgType_ && getContents().equals(request.getContents()) && hasSourceProfile() == request.hasSourceProfile()) {
                    if ((!hasSourceProfile() || getSourceProfile().equals(request.getSourceProfile())) && hasTargetProfile() == request.hasTargetProfile()) {
                        if ((!hasTargetProfile() || getTargetProfile().equals(request.getTargetProfile())) && hasExtra() == request.hasExtra()) {
                            return (!hasExtra() || getExtra().equals(request.getExtra())) && getRoomId() == request.getRoomId() && getSendAnyone() == request.getSendAnyone() && getResend() == request.getResend() && getMembersList().equals(request.getMembersList()) && this.unknownFields.equals(request.unknownFields);
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public CommonOuterClass.Common getCommon() {
            CommonOuterClass.Common common = this.common_;
            CommonOuterClass.Common common2 = common;
            if (common == null) {
                common2 = CommonOuterClass.Common.getDefaultInstance();
            }
            return common2;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public CommonOuterClass.CommonOrBuilder getCommonOrBuilder() {
            return getCommon();
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public String getContents() {
            Object obj = this.contents_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.contents_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
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
        public Request getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public AudioMsgExtra.MsgExtra getExtra() {
            AudioMsgExtra.MsgExtra msgExtra = this.extra_;
            AudioMsgExtra.MsgExtra msgExtra2 = msgExtra;
            if (msgExtra == null) {
                msgExtra2 = AudioMsgExtra.MsgExtra.getDefaultInstance();
            }
            return msgExtra2;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public AudioMsgExtra.MsgExtraOrBuilder getExtraOrBuilder() {
            return getExtra();
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public int getMembers(int i) {
            return this.members_.getInt(i);
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public int getMembersCount() {
            return this.members_.size();
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public List<Integer> getMembersList() {
            return this.members_;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public AudioMsgType.MsgType getMsgType() {
            AudioMsgType.MsgType valueOf = AudioMsgType.MsgType.valueOf(this.msgType_);
            AudioMsgType.MsgType msgType = valueOf;
            if (valueOf == null) {
                msgType = AudioMsgType.MsgType.UNRECOGNIZED;
            }
            return msgType;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public int getMsgTypeValue() {
            return this.msgType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Request> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public boolean getResend() {
            return this.resend_;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public int getRoomId() {
            return this.roomId_;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public int getSendAnyone() {
            return this.sendAnyone_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.common_ != null ? CodedOutputStream.computeMessageSize(1, getCommon()) + 0 : 0;
            int i2 = this.to_;
            int i3 = computeMessageSize;
            if (i2 != 0) {
                i3 = computeMessageSize + CodedOutputStream.computeUInt32Size(2, i2);
            }
            int i4 = i3;
            if (this.msgType_ != AudioMsgType.MsgType.UNKNOWN_MSG_TYPE.getNumber()) {
                i4 = i3 + CodedOutputStream.computeEnumSize(3, this.msgType_);
            }
            int i5 = i4;
            if (!getContentsBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(4, this.contents_);
            }
            int i6 = i5;
            if (this.sourceProfile_ != null) {
                i6 = i5 + CodedOutputStream.computeMessageSize(5, getSourceProfile());
            }
            int i7 = i6;
            if (this.targetProfile_ != null) {
                i7 = i6 + CodedOutputStream.computeMessageSize(6, getTargetProfile());
            }
            int i8 = i7;
            if (this.extra_ != null) {
                i8 = i7 + CodedOutputStream.computeMessageSize(7, getExtra());
            }
            int i9 = this.roomId_;
            int i10 = i8;
            if (i9 != 0) {
                i10 = i8 + CodedOutputStream.computeInt32Size(8, i9);
            }
            int i11 = this.sendAnyone_;
            int i12 = i10;
            if (i11 != 0) {
                i12 = i10 + CodedOutputStream.computeInt32Size(9, i11);
            }
            boolean z = this.resend_;
            int i13 = i12;
            if (z) {
                i13 = i12 + CodedOutputStream.computeBoolSize(10, z);
            }
            int i14 = 0;
            for (int i15 = 0; i15 < this.members_.size(); i15++) {
                i14 += CodedOutputStream.computeUInt32SizeNoTag(this.members_.getInt(i15));
            }
            int i16 = i13 + i14;
            int i17 = i16;
            if (!getMembersList().isEmpty()) {
                i17 = i16 + 1 + CodedOutputStream.computeInt32SizeNoTag(i14);
            }
            this.membersMemoizedSerializedSize = i14;
            int serializedSize = i17 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public AudioMsgExtra.Profile getSourceProfile() {
            AudioMsgExtra.Profile profile = this.sourceProfile_;
            AudioMsgExtra.Profile profile2 = profile;
            if (profile == null) {
                profile2 = AudioMsgExtra.Profile.getDefaultInstance();
            }
            return profile2;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public AudioMsgExtra.ProfileOrBuilder getSourceProfileOrBuilder() {
            return getSourceProfile();
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public AudioMsgExtra.Profile getTargetProfile() {
            AudioMsgExtra.Profile profile = this.targetProfile_;
            AudioMsgExtra.Profile profile2 = profile;
            if (profile == null) {
                profile2 = AudioMsgExtra.Profile.getDefaultInstance();
            }
            return profile2;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public AudioMsgExtra.ProfileOrBuilder getTargetProfileOrBuilder() {
            return getTargetProfile();
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public int getTo() {
            return this.to_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public boolean hasCommon() {
            return this.common_ != null;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public boolean hasExtra() {
            return this.extra_ != null;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public boolean hasSourceProfile() {
            return this.sourceProfile_ != null;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.RequestOrBuilder
        public boolean hasTargetProfile() {
            return this.targetProfile_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            int i = hashCode;
            if (hasCommon()) {
                i = (((hashCode * 37) + 1) * 53) + getCommon().hashCode();
            }
            int to = (((((((((((i * 37) + 2) * 53) + getTo()) * 37) + 3) * 53) + this.msgType_) * 37) + 4) * 53) + getContents().hashCode();
            int i2 = to;
            if (hasSourceProfile()) {
                i2 = (((to * 37) + 5) * 53) + getSourceProfile().hashCode();
            }
            int i3 = i2;
            if (hasTargetProfile()) {
                i3 = (((i2 * 37) + 6) * 53) + getTargetProfile().hashCode();
            }
            int i4 = i3;
            if (hasExtra()) {
                i4 = (((i3 * 37) + 7) * 53) + getExtra().hashCode();
            }
            int roomId = (((((((((((i4 * 37) + 8) * 53) + getRoomId()) * 37) + 9) * 53) + getSendAnyone()) * 37) + 10) * 53) + Internal.hashBoolean(getResend());
            int i5 = roomId;
            if (getMembersCount() > 0) {
                i5 = (((roomId * 37) + 11) * 53) + getMembersList().hashCode();
            }
            int hashCode2 = (i5 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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
            return new Request();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (this.common_ != null) {
                codedOutputStream.writeMessage(1, getCommon());
            }
            int i = this.to_;
            if (i != 0) {
                codedOutputStream.writeUInt32(2, i);
            }
            if (this.msgType_ != AudioMsgType.MsgType.UNKNOWN_MSG_TYPE.getNumber()) {
                codedOutputStream.writeEnum(3, this.msgType_);
            }
            if (!getContentsBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.contents_);
            }
            if (this.sourceProfile_ != null) {
                codedOutputStream.writeMessage(5, getSourceProfile());
            }
            if (this.targetProfile_ != null) {
                codedOutputStream.writeMessage(6, getTargetProfile());
            }
            if (this.extra_ != null) {
                codedOutputStream.writeMessage(7, getExtra());
            }
            int i2 = this.roomId_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(8, i2);
            }
            int i3 = this.sendAnyone_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(9, i3);
            }
            boolean z = this.resend_;
            if (z) {
                codedOutputStream.writeBool(10, z);
            }
            if (getMembersList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(90);
                codedOutputStream.writeUInt32NoTag(this.membersMemoizedSerializedSize);
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= this.members_.size()) {
                    this.unknownFields.writeTo(codedOutputStream);
                    return;
                } else {
                    codedOutputStream.writeUInt32NoTag(this.members_.getInt(i5));
                    i4 = i5 + 1;
                }
            }
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioChatroomOuterClass$RequestOrBuilder.class */
    public interface RequestOrBuilder extends MessageOrBuilder {
        CommonOuterClass.Common getCommon();

        CommonOuterClass.CommonOrBuilder getCommonOrBuilder();

        String getContents();

        ByteString getContentsBytes();

        AudioMsgExtra.MsgExtra getExtra();

        AudioMsgExtra.MsgExtraOrBuilder getExtraOrBuilder();

        int getMembers(int i);

        int getMembersCount();

        List<Integer> getMembersList();

        AudioMsgType.MsgType getMsgType();

        int getMsgTypeValue();

        boolean getResend();

        int getRoomId();

        int getSendAnyone();

        AudioMsgExtra.Profile getSourceProfile();

        AudioMsgExtra.ProfileOrBuilder getSourceProfileOrBuilder();

        AudioMsgExtra.Profile getTargetProfile();

        AudioMsgExtra.ProfileOrBuilder getTargetProfileOrBuilder();

        int getTo();

        boolean hasCommon();

        boolean hasExtra();

        boolean hasSourceProfile();

        boolean hasTargetProfile();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioChatroomOuterClass$Response.class */
    public static final class Response extends GeneratedMessageV3 implements ResponseOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        public static final int MESSAGE_FIELD_NUMBER = 2;
        public static final int REQUEST_ID_FIELD_NUMBER = 3;
        public static final int REQUEST_TIME_FIELD_NUMBER = 4;
        public static final int RESPONSE_TIME_FIELD_NUMBER = 5;
        private static final long serialVersionUID = 0;
        private int code_;
        private byte memoizedIsInitialized;
        private volatile Object message_;
        private volatile Object requestId_;
        private long requestTime_;
        private long responseTime_;
        private static final Response DEFAULT_INSTANCE = new Response();
        private static final Parser<Response> PARSER = new AbstractParser<Response>() { // from class: com.blued.im.audio_chatroom.AudioChatroomOuterClass.Response.1
            @Override // com.google.protobuf.Parser
            public Response parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Response(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioChatroomOuterClass$Response$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResponseOrBuilder {
            private int code_;
            private Object message_;
            private Object requestId_;
            private long requestTime_;
            private long responseTime_;

            private Builder() {
                this.code_ = 0;
                this.message_ = "";
                this.requestId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.code_ = 0;
                this.message_ = "";
                this.requestId_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Response_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Response.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Response build() {
                Response buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Response buildPartial() {
                Response response = new Response(this);
                response.code_ = this.code_;
                response.message_ = this.message_;
                response.requestId_ = this.requestId_;
                response.requestTime_ = this.requestTime_;
                response.responseTime_ = this.responseTime_;
                onBuilt();
                return response;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.code_ = 0;
                this.message_ = "";
                this.requestId_ = "";
                this.requestTime_ = 0L;
                this.responseTime_ = 0L;
                return this;
            }

            public Builder clearCode() {
                this.code_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearMessage() {
                this.message_ = Response.getDefaultInstance().getMessage();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearRequestId() {
                this.requestId_ = Response.getDefaultInstance().getRequestId();
                onChanged();
                return this;
            }

            public Builder clearRequestTime() {
                this.requestTime_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearResponseTime() {
                this.responseTime_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ResponseOrBuilder
            public AudioCode.Code getCode() {
                AudioCode.Code valueOf = AudioCode.Code.valueOf(this.code_);
                AudioCode.Code code = valueOf;
                if (valueOf == null) {
                    code = AudioCode.Code.UNRECOGNIZED;
                }
                return code;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ResponseOrBuilder
            public int getCodeValue() {
                return this.code_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Response getDefaultInstanceForType() {
                return Response.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Response_descriptor;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ResponseOrBuilder
            public String getMessage() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.message_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ResponseOrBuilder
            public ByteString getMessageBytes() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.message_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ResponseOrBuilder
            public String getRequestId() {
                Object obj = this.requestId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.requestId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ResponseOrBuilder
            public ByteString getRequestIdBytes() {
                Object obj = this.requestId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.requestId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ResponseOrBuilder
            public long getRequestTime() {
                return this.requestTime_;
            }

            @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ResponseOrBuilder
            public long getResponseTime() {
                return this.responseTime_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Response response) {
                if (response == Response.getDefaultInstance()) {
                    return this;
                }
                if (response.code_ != 0) {
                    setCodeValue(response.getCodeValue());
                }
                if (!response.getMessage().isEmpty()) {
                    this.message_ = response.message_;
                    onChanged();
                }
                if (!response.getRequestId().isEmpty()) {
                    this.requestId_ = response.requestId_;
                    onChanged();
                }
                if (response.getRequestTime() != 0) {
                    setRequestTime(response.getRequestTime());
                }
                if (response.getResponseTime() != 0) {
                    setResponseTime(response.getResponseTime());
                }
                mergeUnknownFields(response.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.audio_chatroom.AudioChatroomOuterClass.Response.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.audio_chatroom.AudioChatroomOuterClass.Response.access$6100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.audio_chatroom.AudioChatroomOuterClass$Response r0 = (com.blued.im.audio_chatroom.AudioChatroomOuterClass.Response) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.audio_chatroom.AudioChatroomOuterClass$Response$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.audio_chatroom.AudioChatroomOuterClass$Response r0 = (com.blued.im.audio_chatroom.AudioChatroomOuterClass.Response) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.audio_chatroom.AudioChatroomOuterClass$Response$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.audio_chatroom.AudioChatroomOuterClass.Response.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.audio_chatroom.AudioChatroomOuterClass$Response$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Response) {
                    return mergeFrom((Response) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setCode(AudioCode.Code code) {
                if (code != null) {
                    this.code_ = code.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setCodeValue(int i) {
                this.code_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setMessage(String str) {
                if (str != null) {
                    this.message_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMessageBytes(ByteString byteString) {
                if (byteString != null) {
                    Response.checkByteStringIsUtf8(byteString);
                    this.message_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setRequestId(String str) {
                if (str != null) {
                    this.requestId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRequestIdBytes(ByteString byteString) {
                if (byteString != null) {
                    Response.checkByteStringIsUtf8(byteString);
                    this.requestId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRequestTime(long j) {
                this.requestTime_ = j;
                onChanged();
                return this;
            }

            public Builder setResponseTime(long j) {
                this.responseTime_ = j;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private Response() {
            this.memoizedIsInitialized = (byte) -1;
            this.code_ = 0;
            this.message_ = "";
            this.requestId_ = "";
        }

        private Response(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.code_ = codedInputStream.readEnum();
                            } else if (readTag == 18) {
                                this.message_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.requestId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 32) {
                                this.requestTime_ = codedInputStream.readInt64();
                            } else if (readTag == 40) {
                                this.responseTime_ = codedInputStream.readInt64();
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

        private Response(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Response getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Response_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Response response) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(response);
        }

        public static Response parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Response parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Response parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Response parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Response parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Response parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Response parseFrom(InputStream inputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Response parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Response parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Response parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Response parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Response parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Response> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Response) {
                Response response = (Response) obj;
                return this.code_ == response.code_ && getMessage().equals(response.getMessage()) && getRequestId().equals(response.getRequestId()) && getRequestTime() == response.getRequestTime() && getResponseTime() == response.getResponseTime() && this.unknownFields.equals(response.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ResponseOrBuilder
        public AudioCode.Code getCode() {
            AudioCode.Code valueOf = AudioCode.Code.valueOf(this.code_);
            AudioCode.Code code = valueOf;
            if (valueOf == null) {
                code = AudioCode.Code.UNRECOGNIZED;
            }
            return code;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ResponseOrBuilder
        public int getCodeValue() {
            return this.code_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Response getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ResponseOrBuilder
        public String getMessage() {
            Object obj = this.message_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.message_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ResponseOrBuilder
        public ByteString getMessageBytes() {
            Object obj = this.message_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.message_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Response> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ResponseOrBuilder
        public String getRequestId() {
            Object obj = this.requestId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.requestId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ResponseOrBuilder
        public ByteString getRequestIdBytes() {
            Object obj = this.requestId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.requestId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ResponseOrBuilder
        public long getRequestTime() {
            return this.requestTime_;
        }

        @Override // com.blued.im.audio_chatroom.AudioChatroomOuterClass.ResponseOrBuilder
        public long getResponseTime() {
            return this.responseTime_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.code_ != AudioCode.Code.AUDIO_SEND_SUCCESS.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.code_);
            }
            int i3 = i2;
            if (!getMessageBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.message_);
            }
            int i4 = i3;
            if (!getRequestIdBytes().isEmpty()) {
                i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.requestId_);
            }
            long j = this.requestTime_;
            int i5 = i4;
            if (j != 0) {
                i5 = i4 + CodedOutputStream.computeInt64Size(4, j);
            }
            long j2 = this.responseTime_;
            int i6 = i5;
            if (j2 != 0) {
                i6 = i5 + CodedOutputStream.computeInt64Size(5, j2);
            }
            int serializedSize = i6 + this.unknownFields.getSerializedSize();
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
            int hashCode = ((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.code_) * 37) + 2) * 53) + getMessage().hashCode()) * 37) + 3) * 53) + getRequestId().hashCode()) * 37) + 4) * 53) + Internal.hashLong(getRequestTime())) * 37) + 5) * 53) + Internal.hashLong(getResponseTime())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
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
            return new Response();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.code_ != AudioCode.Code.AUDIO_SEND_SUCCESS.getNumber()) {
                codedOutputStream.writeEnum(1, this.code_);
            }
            if (!getMessageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.message_);
            }
            if (!getRequestIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.requestId_);
            }
            long j = this.requestTime_;
            if (j != 0) {
                codedOutputStream.writeInt64(4, j);
            }
            long j2 = this.responseTime_;
            if (j2 != 0) {
                codedOutputStream.writeInt64(5, j2);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioChatroomOuterClass$ResponseOrBuilder.class */
    public interface ResponseOrBuilder extends MessageOrBuilder {
        AudioCode.Code getCode();

        int getCodeValue();

        String getMessage();

        ByteString getMessageBytes();

        String getRequestId();

        ByteString getRequestIdBytes();

        long getRequestTime();

        long getResponseTime();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_im_audio_chatroom_Request_descriptor = descriptor2;
        internal_static_com_blued_im_audio_chatroom_Request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Common", "To", "MsgType", "Contents", "SourceProfile", "TargetProfile", "Extra", TXCopyrightedMedia.EXT_INFO_ROOM_ID, "SendAnyone", "Resend", "Members"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_blued_im_audio_chatroom_Receive_descriptor = descriptor3;
        internal_static_com_blued_im_audio_chatroom_Receive_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{HttpHeaders.FROM, "MsgType", "Contents", "SourceProfile", "TargetProfile", "Extra", TXCopyrightedMedia.EXT_INFO_ROOM_ID, "MsgTime", "Resend", "Members"});
        Descriptors.Descriptor descriptor4 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_blued_im_audio_chatroom_Response_descriptor = descriptor4;
        internal_static_com_blued_im_audio_chatroom_Response_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Code", "Message", "RequestId", "RequestTime", "ResponseTime"});
        AudioMsgExtra.getDescriptor();
        AudioMsgType.getDescriptor();
        AudioCode.getDescriptor();
        CommonOuterClass.getDescriptor();
    }

    private AudioChatroomOuterClass() {
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
