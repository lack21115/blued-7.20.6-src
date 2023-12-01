package com.blued.im.private_chat;

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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PushProfileOuterClass.class */
public final class PushProfileOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011PushProfile.proto\u0012\u0019com.blued.im.private_chat\"¡\u0003\n\u000bPushProfile\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006avatar\u0018\u0002 \u0001(\t\u0012\u000e\n\u0006coords\u0018\u0003 \u0003(\u0001\u0012\u000e\n\u0006vbadge\u0018\u0004 \u0001(\u0005\u0012\u000e\n\u0006online\u0018\u0005 \u0001(\u0005\u0012\u000e\n\u0006friend\u0018\u0006 \u0001(\u0005\u0012\u0012\n\nrich_level\u0018\u0007 \u0001(\u0005\u0012\u0014\n\fo_rich_level\u0018\b \u0001(\u0005\u0012\u0012\n\nvip_annual\u0018\t \u0001(\u0005\u0012\u0011\n\tvip_grade\u0018\n \u0001(\u0005\u0012\u0013\n\u000bvip_exp_lvl\u0018\u000b \u0001(\u0005\u0012\u0013\n\u000bo_vip_grade\u0018\f \u0001(\u0005\u0012\u0018\n\u0010is_hide_vip_look\u0018\u000e \u0001(\u0005\u0012\u001a\n\u0012o_is_hide_vip_look\u0018\u000f \u0001(\u0005\u0012\u0016\n\u000eavatar_pendant\u0018\u0010 \u0001(\t\u0012\u0014\n\fdevice_token\u0018\u0011 \u0001(\u0005\u0012\u0015\n\rshadow_coords\u0018\u0012 \u0003(\u0001\u0012\u0015\n\ro_face_status\u0018\u0013 \u0001(\u0005\u0012\u0012\n\nis_manager\u0018\u0014 \u0001(\u0005\u0012\u0013\n\u000bprompt_type\u0018\u0015 \u0001(\tB\u000e¢\u0002\u000bPrivateChatb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_PushProfile_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_PushProfile_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PushProfileOuterClass$PushProfile.class */
    public static final class PushProfile extends GeneratedMessageV3 implements PushProfileOrBuilder {
        public static final int AVATAR_FIELD_NUMBER = 2;
        public static final int AVATAR_PENDANT_FIELD_NUMBER = 16;
        public static final int COORDS_FIELD_NUMBER = 3;
        public static final int DEVICE_TOKEN_FIELD_NUMBER = 17;
        public static final int FRIEND_FIELD_NUMBER = 6;
        public static final int IS_HIDE_VIP_LOOK_FIELD_NUMBER = 14;
        public static final int IS_MANAGER_FIELD_NUMBER = 20;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int ONLINE_FIELD_NUMBER = 5;
        public static final int O_FACE_STATUS_FIELD_NUMBER = 19;
        public static final int O_IS_HIDE_VIP_LOOK_FIELD_NUMBER = 15;
        public static final int O_RICH_LEVEL_FIELD_NUMBER = 8;
        public static final int O_VIP_GRADE_FIELD_NUMBER = 12;
        public static final int PROMPT_TYPE_FIELD_NUMBER = 21;
        public static final int RICH_LEVEL_FIELD_NUMBER = 7;
        public static final int SHADOW_COORDS_FIELD_NUMBER = 18;
        public static final int VBADGE_FIELD_NUMBER = 4;
        public static final int VIP_ANNUAL_FIELD_NUMBER = 9;
        public static final int VIP_EXP_LVL_FIELD_NUMBER = 11;
        public static final int VIP_GRADE_FIELD_NUMBER = 10;
        private static final long serialVersionUID = 0;
        private volatile Object avatarPendant_;
        private volatile Object avatar_;
        private int coordsMemoizedSerializedSize;
        private Internal.DoubleList coords_;
        private int deviceToken_;
        private int friend_;
        private int isHideVipLook_;
        private int isManager_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private int oFaceStatus_;
        private int oIsHideVipLook_;
        private int oRichLevel_;
        private int oVipGrade_;
        private int online_;
        private volatile Object promptType_;
        private int richLevel_;
        private int shadowCoordsMemoizedSerializedSize;
        private Internal.DoubleList shadowCoords_;
        private int vbadge_;
        private int vipAnnual_;
        private int vipExpLvl_;
        private int vipGrade_;
        private static final PushProfile DEFAULT_INSTANCE = new PushProfile();
        private static final Parser<PushProfile> PARSER = new AbstractParser<PushProfile>() { // from class: com.blued.im.private_chat.PushProfileOuterClass.PushProfile.1
            @Override // com.google.protobuf.Parser
            public PushProfile parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PushProfile(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PushProfileOuterClass$PushProfile$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PushProfileOrBuilder {
            private Object avatarPendant_;
            private Object avatar_;
            private int bitField0_;
            private Internal.DoubleList coords_;
            private int deviceToken_;
            private int friend_;
            private int isHideVipLook_;
            private int isManager_;
            private Object name_;
            private int oFaceStatus_;
            private int oIsHideVipLook_;
            private int oRichLevel_;
            private int oVipGrade_;
            private int online_;
            private Object promptType_;
            private int richLevel_;
            private Internal.DoubleList shadowCoords_;
            private int vbadge_;
            private int vipAnnual_;
            private int vipExpLvl_;
            private int vipGrade_;

            private Builder() {
                this.name_ = "";
                this.avatar_ = "";
                this.coords_ = PushProfile.access$3200();
                this.avatarPendant_ = "";
                this.shadowCoords_ = PushProfile.access$3600();
                this.promptType_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.name_ = "";
                this.avatar_ = "";
                this.coords_ = PushProfile.access$3200();
                this.avatarPendant_ = "";
                this.shadowCoords_ = PushProfile.access$3600();
                this.promptType_ = "";
                maybeForceBuilderInitialization();
            }

            private void ensureCoordsIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.coords_ = PushProfile.mutableCopy(this.coords_);
                    this.bitField0_ |= 1;
                }
            }

            private void ensureShadowCoordsIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.shadowCoords_ = PushProfile.mutableCopy(this.shadowCoords_);
                    this.bitField0_ |= 2;
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PushProfileOuterClass.internal_static_com_blued_im_private_chat_PushProfile_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = PushProfile.alwaysUseFieldBuilders;
            }

            public Builder addAllCoords(Iterable<? extends Double> iterable) {
                ensureCoordsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.coords_);
                onChanged();
                return this;
            }

            public Builder addAllShadowCoords(Iterable<? extends Double> iterable) {
                ensureShadowCoordsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.shadowCoords_);
                onChanged();
                return this;
            }

            public Builder addCoords(double d) {
                ensureCoordsIsMutable();
                this.coords_.addDouble(d);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public Builder addShadowCoords(double d) {
                ensureShadowCoordsIsMutable();
                this.shadowCoords_.addDouble(d);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PushProfile build() {
                PushProfile buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PushProfile buildPartial() {
                PushProfile pushProfile = new PushProfile(this);
                pushProfile.name_ = this.name_;
                pushProfile.avatar_ = this.avatar_;
                if ((this.bitField0_ & 1) != 0) {
                    this.coords_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                pushProfile.coords_ = this.coords_;
                pushProfile.vbadge_ = this.vbadge_;
                pushProfile.online_ = this.online_;
                pushProfile.friend_ = this.friend_;
                pushProfile.richLevel_ = this.richLevel_;
                pushProfile.oRichLevel_ = this.oRichLevel_;
                pushProfile.vipAnnual_ = this.vipAnnual_;
                pushProfile.vipGrade_ = this.vipGrade_;
                pushProfile.vipExpLvl_ = this.vipExpLvl_;
                pushProfile.oVipGrade_ = this.oVipGrade_;
                pushProfile.isHideVipLook_ = this.isHideVipLook_;
                pushProfile.oIsHideVipLook_ = this.oIsHideVipLook_;
                pushProfile.avatarPendant_ = this.avatarPendant_;
                pushProfile.deviceToken_ = this.deviceToken_;
                if ((this.bitField0_ & 2) != 0) {
                    this.shadowCoords_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                pushProfile.shadowCoords_ = this.shadowCoords_;
                pushProfile.oFaceStatus_ = this.oFaceStatus_;
                pushProfile.isManager_ = this.isManager_;
                pushProfile.promptType_ = this.promptType_;
                onBuilt();
                return pushProfile;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.name_ = "";
                this.avatar_ = "";
                this.coords_ = PushProfile.access$500();
                this.bitField0_ &= -2;
                this.vbadge_ = 0;
                this.online_ = 0;
                this.friend_ = 0;
                this.richLevel_ = 0;
                this.oRichLevel_ = 0;
                this.vipAnnual_ = 0;
                this.vipGrade_ = 0;
                this.vipExpLvl_ = 0;
                this.oVipGrade_ = 0;
                this.isHideVipLook_ = 0;
                this.oIsHideVipLook_ = 0;
                this.avatarPendant_ = "";
                this.deviceToken_ = 0;
                this.shadowCoords_ = PushProfile.access$600();
                this.bitField0_ &= -3;
                this.oFaceStatus_ = 0;
                this.isManager_ = 0;
                this.promptType_ = "";
                return this;
            }

            public Builder clearAvatar() {
                this.avatar_ = PushProfile.getDefaultInstance().getAvatar();
                onChanged();
                return this;
            }

            public Builder clearAvatarPendant() {
                this.avatarPendant_ = PushProfile.getDefaultInstance().getAvatarPendant();
                onChanged();
                return this;
            }

            public Builder clearCoords() {
                this.coords_ = PushProfile.access$3400();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder clearDeviceToken() {
                this.deviceToken_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearFriend() {
                this.friend_ = 0;
                onChanged();
                return this;
            }

            public Builder clearIsHideVipLook() {
                this.isHideVipLook_ = 0;
                onChanged();
                return this;
            }

            public Builder clearIsManager() {
                this.isManager_ = 0;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = PushProfile.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder clearOFaceStatus() {
                this.oFaceStatus_ = 0;
                onChanged();
                return this;
            }

            public Builder clearOIsHideVipLook() {
                this.oIsHideVipLook_ = 0;
                onChanged();
                return this;
            }

            public Builder clearORichLevel() {
                this.oRichLevel_ = 0;
                onChanged();
                return this;
            }

            public Builder clearOVipGrade() {
                this.oVipGrade_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearOnline() {
                this.online_ = 0;
                onChanged();
                return this;
            }

            public Builder clearPromptType() {
                this.promptType_ = PushProfile.getDefaultInstance().getPromptType();
                onChanged();
                return this;
            }

            public Builder clearRichLevel() {
                this.richLevel_ = 0;
                onChanged();
                return this;
            }

            public Builder clearShadowCoords() {
                this.shadowCoords_ = PushProfile.access$3800();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            public Builder clearVbadge() {
                this.vbadge_ = 0;
                onChanged();
                return this;
            }

            public Builder clearVipAnnual() {
                this.vipAnnual_ = 0;
                onChanged();
                return this;
            }

            public Builder clearVipExpLvl() {
                this.vipExpLvl_ = 0;
                onChanged();
                return this;
            }

            public Builder clearVipGrade() {
                this.vipGrade_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public String getAvatar() {
                Object obj = this.avatar_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.avatar_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public ByteString getAvatarBytes() {
                Object obj = this.avatar_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.avatar_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public String getAvatarPendant() {
                Object obj = this.avatarPendant_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.avatarPendant_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public ByteString getAvatarPendantBytes() {
                Object obj = this.avatarPendant_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.avatarPendant_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public double getCoords(int i) {
                return this.coords_.getDouble(i);
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public int getCoordsCount() {
                return this.coords_.size();
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public List<Double> getCoordsList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.coords_) : this.coords_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PushProfile getDefaultInstanceForType() {
                return PushProfile.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PushProfileOuterClass.internal_static_com_blued_im_private_chat_PushProfile_descriptor;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public int getDeviceToken() {
                return this.deviceToken_;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public int getFriend() {
                return this.friend_;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public int getIsHideVipLook() {
                return this.isHideVipLook_;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public int getIsManager() {
                return this.isManager_;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public int getOFaceStatus() {
                return this.oFaceStatus_;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public int getOIsHideVipLook() {
                return this.oIsHideVipLook_;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public int getORichLevel() {
                return this.oRichLevel_;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public int getOVipGrade() {
                return this.oVipGrade_;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public int getOnline() {
                return this.online_;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public String getPromptType() {
                Object obj = this.promptType_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.promptType_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public ByteString getPromptTypeBytes() {
                Object obj = this.promptType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.promptType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public int getRichLevel() {
                return this.richLevel_;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public double getShadowCoords(int i) {
                return this.shadowCoords_.getDouble(i);
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public int getShadowCoordsCount() {
                return this.shadowCoords_.size();
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public List<Double> getShadowCoordsList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.shadowCoords_) : this.shadowCoords_;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public int getVbadge() {
                return this.vbadge_;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public int getVipAnnual() {
                return this.vipAnnual_;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public int getVipExpLvl() {
                return this.vipExpLvl_;
            }

            @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
            public int getVipGrade() {
                return this.vipGrade_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PushProfileOuterClass.internal_static_com_blued_im_private_chat_PushProfile_fieldAccessorTable.ensureFieldAccessorsInitialized(PushProfile.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(PushProfile pushProfile) {
                if (pushProfile == PushProfile.getDefaultInstance()) {
                    return this;
                }
                if (!pushProfile.getName().isEmpty()) {
                    this.name_ = pushProfile.name_;
                    onChanged();
                }
                if (!pushProfile.getAvatar().isEmpty()) {
                    this.avatar_ = pushProfile.avatar_;
                    onChanged();
                }
                if (!pushProfile.coords_.isEmpty()) {
                    if (this.coords_.isEmpty()) {
                        this.coords_ = pushProfile.coords_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureCoordsIsMutable();
                        this.coords_.addAll(pushProfile.coords_);
                    }
                    onChanged();
                }
                if (pushProfile.getVbadge() != 0) {
                    setVbadge(pushProfile.getVbadge());
                }
                if (pushProfile.getOnline() != 0) {
                    setOnline(pushProfile.getOnline());
                }
                if (pushProfile.getFriend() != 0) {
                    setFriend(pushProfile.getFriend());
                }
                if (pushProfile.getRichLevel() != 0) {
                    setRichLevel(pushProfile.getRichLevel());
                }
                if (pushProfile.getORichLevel() != 0) {
                    setORichLevel(pushProfile.getORichLevel());
                }
                if (pushProfile.getVipAnnual() != 0) {
                    setVipAnnual(pushProfile.getVipAnnual());
                }
                if (pushProfile.getVipGrade() != 0) {
                    setVipGrade(pushProfile.getVipGrade());
                }
                if (pushProfile.getVipExpLvl() != 0) {
                    setVipExpLvl(pushProfile.getVipExpLvl());
                }
                if (pushProfile.getOVipGrade() != 0) {
                    setOVipGrade(pushProfile.getOVipGrade());
                }
                if (pushProfile.getIsHideVipLook() != 0) {
                    setIsHideVipLook(pushProfile.getIsHideVipLook());
                }
                if (pushProfile.getOIsHideVipLook() != 0) {
                    setOIsHideVipLook(pushProfile.getOIsHideVipLook());
                }
                if (!pushProfile.getAvatarPendant().isEmpty()) {
                    this.avatarPendant_ = pushProfile.avatarPendant_;
                    onChanged();
                }
                if (pushProfile.getDeviceToken() != 0) {
                    setDeviceToken(pushProfile.getDeviceToken());
                }
                if (!pushProfile.shadowCoords_.isEmpty()) {
                    if (this.shadowCoords_.isEmpty()) {
                        this.shadowCoords_ = pushProfile.shadowCoords_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureShadowCoordsIsMutable();
                        this.shadowCoords_.addAll(pushProfile.shadowCoords_);
                    }
                    onChanged();
                }
                if (pushProfile.getOFaceStatus() != 0) {
                    setOFaceStatus(pushProfile.getOFaceStatus());
                }
                if (pushProfile.getIsManager() != 0) {
                    setIsManager(pushProfile.getIsManager());
                }
                if (!pushProfile.getPromptType().isEmpty()) {
                    this.promptType_ = pushProfile.promptType_;
                    onChanged();
                }
                mergeUnknownFields(pushProfile.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.private_chat.PushProfileOuterClass.PushProfile.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.private_chat.PushProfileOuterClass.PushProfile.access$2900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.private_chat.PushProfileOuterClass$PushProfile r0 = (com.blued.im.private_chat.PushProfileOuterClass.PushProfile) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.PushProfileOuterClass$PushProfile$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.private_chat.PushProfileOuterClass$PushProfile r0 = (com.blued.im.private_chat.PushProfileOuterClass.PushProfile) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.private_chat.PushProfileOuterClass$PushProfile$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.private_chat.PushProfileOuterClass.PushProfile.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.private_chat.PushProfileOuterClass$PushProfile$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof PushProfile) {
                    return mergeFrom((PushProfile) message);
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
                    PushProfile.checkByteStringIsUtf8(byteString);
                    this.avatar_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAvatarPendant(String str) {
                if (str != null) {
                    this.avatarPendant_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAvatarPendantBytes(ByteString byteString) {
                if (byteString != null) {
                    PushProfile.checkByteStringIsUtf8(byteString);
                    this.avatarPendant_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setCoords(int i, double d) {
                ensureCoordsIsMutable();
                this.coords_.setDouble(i, d);
                onChanged();
                return this;
            }

            public Builder setDeviceToken(int i) {
                this.deviceToken_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setFriend(int i) {
                this.friend_ = i;
                onChanged();
                return this;
            }

            public Builder setIsHideVipLook(int i) {
                this.isHideVipLook_ = i;
                onChanged();
                return this;
            }

            public Builder setIsManager(int i) {
                this.isManager_ = i;
                onChanged();
                return this;
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
                    PushProfile.checkByteStringIsUtf8(byteString);
                    this.name_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setOFaceStatus(int i) {
                this.oFaceStatus_ = i;
                onChanged();
                return this;
            }

            public Builder setOIsHideVipLook(int i) {
                this.oIsHideVipLook_ = i;
                onChanged();
                return this;
            }

            public Builder setORichLevel(int i) {
                this.oRichLevel_ = i;
                onChanged();
                return this;
            }

            public Builder setOVipGrade(int i) {
                this.oVipGrade_ = i;
                onChanged();
                return this;
            }

            public Builder setOnline(int i) {
                this.online_ = i;
                onChanged();
                return this;
            }

            public Builder setPromptType(String str) {
                if (str != null) {
                    this.promptType_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPromptTypeBytes(ByteString byteString) {
                if (byteString != null) {
                    PushProfile.checkByteStringIsUtf8(byteString);
                    this.promptType_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setRichLevel(int i) {
                this.richLevel_ = i;
                onChanged();
                return this;
            }

            public Builder setShadowCoords(int i, double d) {
                ensureShadowCoordsIsMutable();
                this.shadowCoords_.setDouble(i, d);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public Builder setVbadge(int i) {
                this.vbadge_ = i;
                onChanged();
                return this;
            }

            public Builder setVipAnnual(int i) {
                this.vipAnnual_ = i;
                onChanged();
                return this;
            }

            public Builder setVipExpLvl(int i) {
                this.vipExpLvl_ = i;
                onChanged();
                return this;
            }

            public Builder setVipGrade(int i) {
                this.vipGrade_ = i;
                onChanged();
                return this;
            }
        }

        private PushProfile() {
            this.coordsMemoizedSerializedSize = -1;
            this.shadowCoordsMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.avatar_ = "";
            this.coords_ = emptyDoubleList();
            this.avatarPendant_ = "";
            this.shadowCoords_ = emptyDoubleList();
            this.promptType_ = "";
        }

        private PushProfile(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                this.name_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 18:
                                this.avatar_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 25:
                                boolean z4 = z2;
                                if (!(z2 & true)) {
                                    this.coords_ = newDoubleList();
                                    z4 = z2 | true;
                                }
                                this.coords_.addDouble(codedInputStream.readDouble());
                                z2 = z4;
                                continue;
                            case 26:
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                boolean z5 = z2;
                                if (!(z2 & true)) {
                                    z5 = z2;
                                    if (codedInputStream.getBytesUntilLimit() > 0) {
                                        boolean z6 = z2;
                                        this.coords_ = newDoubleList();
                                        z5 = z2 | true;
                                    }
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    boolean z7 = z5;
                                    this.coords_.addDouble(codedInputStream.readDouble());
                                }
                                codedInputStream.popLimit(pushLimit);
                                z2 = z5;
                                continue;
                            case 32:
                                this.vbadge_ = codedInputStream.readInt32();
                                continue;
                            case 40:
                                this.online_ = codedInputStream.readInt32();
                                continue;
                            case 48:
                                this.friend_ = codedInputStream.readInt32();
                                continue;
                            case 56:
                                this.richLevel_ = codedInputStream.readInt32();
                                continue;
                            case 64:
                                this.oRichLevel_ = codedInputStream.readInt32();
                                continue;
                            case 72:
                                this.vipAnnual_ = codedInputStream.readInt32();
                                continue;
                            case 80:
                                this.vipGrade_ = codedInputStream.readInt32();
                                continue;
                            case 88:
                                this.vipExpLvl_ = codedInputStream.readInt32();
                                continue;
                            case 96:
                                this.oVipGrade_ = codedInputStream.readInt32();
                                continue;
                            case 112:
                                this.isHideVipLook_ = codedInputStream.readInt32();
                                continue;
                            case 120:
                                this.oIsHideVipLook_ = codedInputStream.readInt32();
                                continue;
                            case 130:
                                this.avatarPendant_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 136:
                                this.deviceToken_ = codedInputStream.readInt32();
                                continue;
                            case 145:
                                boolean z8 = z2;
                                if (!(z2 & true)) {
                                    this.shadowCoords_ = newDoubleList();
                                    z8 = z2 | true;
                                }
                                this.shadowCoords_.addDouble(codedInputStream.readDouble());
                                z2 = z8;
                                continue;
                            case 146:
                                int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                boolean z9 = z2;
                                if (!(z2 & true)) {
                                    z9 = z2;
                                    if (codedInputStream.getBytesUntilLimit() > 0) {
                                        boolean z10 = z2;
                                        this.shadowCoords_ = newDoubleList();
                                        z9 = z2 | true;
                                    }
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    boolean z11 = z9;
                                    this.shadowCoords_.addDouble(codedInputStream.readDouble());
                                }
                                codedInputStream.popLimit(pushLimit2);
                                z2 = z9;
                                continue;
                            case 152:
                                this.oFaceStatus_ = codedInputStream.readInt32();
                                continue;
                            case 160:
                                this.isManager_ = codedInputStream.readInt32();
                                continue;
                            case 170:
                                this.promptType_ = codedInputStream.readStringRequireUtf8();
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
                        this.coords_.makeImmutable();
                    }
                    if (z3 & true) {
                        this.shadowCoords_.makeImmutable();
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.coords_.makeImmutable();
            }
            if (z2 & true) {
                this.shadowCoords_.makeImmutable();
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }

        private PushProfile(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.coordsMemoizedSerializedSize = -1;
            this.shadowCoordsMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        static /* synthetic */ Internal.DoubleList access$3200() {
            return emptyDoubleList();
        }

        static /* synthetic */ Internal.DoubleList access$3400() {
            return emptyDoubleList();
        }

        static /* synthetic */ Internal.DoubleList access$3600() {
            return emptyDoubleList();
        }

        static /* synthetic */ Internal.DoubleList access$3800() {
            return emptyDoubleList();
        }

        static /* synthetic */ Internal.DoubleList access$500() {
            return emptyDoubleList();
        }

        static /* synthetic */ Internal.DoubleList access$600() {
            return emptyDoubleList();
        }

        public static PushProfile getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PushProfileOuterClass.internal_static_com_blued_im_private_chat_PushProfile_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PushProfile pushProfile) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(pushProfile);
        }

        public static PushProfile parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PushProfile) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static PushProfile parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PushProfile) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PushProfile parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static PushProfile parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static PushProfile parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PushProfile) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static PushProfile parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PushProfile) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static PushProfile parseFrom(InputStream inputStream) throws IOException {
            return (PushProfile) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static PushProfile parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PushProfile) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PushProfile parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static PushProfile parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static PushProfile parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static PushProfile parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<PushProfile> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof PushProfile) {
                PushProfile pushProfile = (PushProfile) obj;
                return getName().equals(pushProfile.getName()) && getAvatar().equals(pushProfile.getAvatar()) && getCoordsList().equals(pushProfile.getCoordsList()) && getVbadge() == pushProfile.getVbadge() && getOnline() == pushProfile.getOnline() && getFriend() == pushProfile.getFriend() && getRichLevel() == pushProfile.getRichLevel() && getORichLevel() == pushProfile.getORichLevel() && getVipAnnual() == pushProfile.getVipAnnual() && getVipGrade() == pushProfile.getVipGrade() && getVipExpLvl() == pushProfile.getVipExpLvl() && getOVipGrade() == pushProfile.getOVipGrade() && getIsHideVipLook() == pushProfile.getIsHideVipLook() && getOIsHideVipLook() == pushProfile.getOIsHideVipLook() && getAvatarPendant().equals(pushProfile.getAvatarPendant()) && getDeviceToken() == pushProfile.getDeviceToken() && getShadowCoordsList().equals(pushProfile.getShadowCoordsList()) && getOFaceStatus() == pushProfile.getOFaceStatus() && getIsManager() == pushProfile.getIsManager() && getPromptType().equals(pushProfile.getPromptType()) && this.unknownFields.equals(pushProfile.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public String getAvatar() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public ByteString getAvatarBytes() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.avatar_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public String getAvatarPendant() {
            Object obj = this.avatarPendant_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatarPendant_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public ByteString getAvatarPendantBytes() {
            Object obj = this.avatarPendant_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.avatarPendant_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public double getCoords(int i) {
            return this.coords_.getDouble(i);
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public int getCoordsCount() {
            return this.coords_.size();
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public List<Double> getCoordsList() {
            return this.coords_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PushProfile getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public int getDeviceToken() {
            return this.deviceToken_;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public int getFriend() {
            return this.friend_;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public int getIsHideVipLook() {
            return this.isHideVipLook_;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public int getIsManager() {
            return this.isManager_;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public int getOFaceStatus() {
            return this.oFaceStatus_;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public int getOIsHideVipLook() {
            return this.oIsHideVipLook_;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public int getORichLevel() {
            return this.oRichLevel_;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public int getOVipGrade() {
            return this.oVipGrade_;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public int getOnline() {
            return this.online_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PushProfile> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public String getPromptType() {
            Object obj = this.promptType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.promptType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public ByteString getPromptTypeBytes() {
            Object obj = this.promptType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.promptType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public int getRichLevel() {
            return this.richLevel_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getNameBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
            }
            int i3 = i2;
            if (!getAvatarBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.avatar_);
            }
            int size = getCoordsList().size() * 8;
            int i4 = i3 + size;
            int i5 = i4;
            if (!getCoordsList().isEmpty()) {
                i5 = i4 + 1 + CodedOutputStream.computeInt32SizeNoTag(size);
            }
            this.coordsMemoizedSerializedSize = size;
            int i6 = this.vbadge_;
            int i7 = i5;
            if (i6 != 0) {
                i7 = i5 + CodedOutputStream.computeInt32Size(4, i6);
            }
            int i8 = this.online_;
            int i9 = i7;
            if (i8 != 0) {
                i9 = i7 + CodedOutputStream.computeInt32Size(5, i8);
            }
            int i10 = this.friend_;
            int i11 = i9;
            if (i10 != 0) {
                i11 = i9 + CodedOutputStream.computeInt32Size(6, i10);
            }
            int i12 = this.richLevel_;
            int i13 = i11;
            if (i12 != 0) {
                i13 = i11 + CodedOutputStream.computeInt32Size(7, i12);
            }
            int i14 = this.oRichLevel_;
            int i15 = i13;
            if (i14 != 0) {
                i15 = i13 + CodedOutputStream.computeInt32Size(8, i14);
            }
            int i16 = this.vipAnnual_;
            int i17 = i15;
            if (i16 != 0) {
                i17 = i15 + CodedOutputStream.computeInt32Size(9, i16);
            }
            int i18 = this.vipGrade_;
            int i19 = i17;
            if (i18 != 0) {
                i19 = i17 + CodedOutputStream.computeInt32Size(10, i18);
            }
            int i20 = this.vipExpLvl_;
            int i21 = i19;
            if (i20 != 0) {
                i21 = i19 + CodedOutputStream.computeInt32Size(11, i20);
            }
            int i22 = this.oVipGrade_;
            int i23 = i21;
            if (i22 != 0) {
                i23 = i21 + CodedOutputStream.computeInt32Size(12, i22);
            }
            int i24 = this.isHideVipLook_;
            int i25 = i23;
            if (i24 != 0) {
                i25 = i23 + CodedOutputStream.computeInt32Size(14, i24);
            }
            int i26 = this.oIsHideVipLook_;
            int i27 = i25;
            if (i26 != 0) {
                i27 = i25 + CodedOutputStream.computeInt32Size(15, i26);
            }
            int i28 = i27;
            if (!getAvatarPendantBytes().isEmpty()) {
                i28 = i27 + GeneratedMessageV3.computeStringSize(16, this.avatarPendant_);
            }
            int i29 = this.deviceToken_;
            int i30 = i28;
            if (i29 != 0) {
                i30 = i28 + CodedOutputStream.computeInt32Size(17, i29);
            }
            int size2 = getShadowCoordsList().size() * 8;
            int i31 = i30 + size2;
            int i32 = i31;
            if (!getShadowCoordsList().isEmpty()) {
                i32 = i31 + 2 + CodedOutputStream.computeInt32SizeNoTag(size2);
            }
            this.shadowCoordsMemoizedSerializedSize = size2;
            int i33 = this.oFaceStatus_;
            int i34 = i32;
            if (i33 != 0) {
                i34 = i32 + CodedOutputStream.computeInt32Size(19, i33);
            }
            int i35 = this.isManager_;
            int i36 = i34;
            if (i35 != 0) {
                i36 = i34 + CodedOutputStream.computeInt32Size(20, i35);
            }
            int i37 = i36;
            if (!getPromptTypeBytes().isEmpty()) {
                i37 = i36 + GeneratedMessageV3.computeStringSize(21, this.promptType_);
            }
            int serializedSize = i37 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public double getShadowCoords(int i) {
            return this.shadowCoords_.getDouble(i);
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public int getShadowCoordsCount() {
            return this.shadowCoords_.size();
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public List<Double> getShadowCoordsList() {
            return this.shadowCoords_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public int getVbadge() {
            return this.vbadge_;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public int getVipAnnual() {
            return this.vipAnnual_;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public int getVipExpLvl() {
            return this.vipExpLvl_;
        }

        @Override // com.blued.im.private_chat.PushProfileOuterClass.PushProfileOrBuilder
        public int getVipGrade() {
            return this.vipGrade_;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getAvatar().hashCode();
            int i = hashCode;
            if (getCoordsCount() > 0) {
                i = (((hashCode * 37) + 3) * 53) + getCoordsList().hashCode();
            }
            int vbadge = (((((((((((((((((((((((((((((((((((((((((((((((((((i * 37) + 4) * 53) + getVbadge()) * 37) + 5) * 53) + getOnline()) * 37) + 6) * 53) + getFriend()) * 37) + 7) * 53) + getRichLevel()) * 37) + 8) * 53) + getORichLevel()) * 37) + 9) * 53) + getVipAnnual()) * 37) + 10) * 53) + getVipGrade()) * 37) + 11) * 53) + getVipExpLvl()) * 37) + 12) * 53) + getOVipGrade()) * 37) + 14) * 53) + getIsHideVipLook()) * 37) + 15) * 53) + getOIsHideVipLook()) * 37) + 16) * 53) + getAvatarPendant().hashCode()) * 37) + 17) * 53) + getDeviceToken();
            int i2 = vbadge;
            if (getShadowCoordsCount() > 0) {
                i2 = (((vbadge * 37) + 18) * 53) + getShadowCoordsList().hashCode();
            }
            int oFaceStatus = (((((((((((((i2 * 37) + 19) * 53) + getOFaceStatus()) * 37) + 20) * 53) + getIsManager()) * 37) + 21) * 53) + getPromptType().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = oFaceStatus;
            return oFaceStatus;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PushProfileOuterClass.internal_static_com_blued_im_private_chat_PushProfile_fieldAccessorTable.ensureFieldAccessorsInitialized(PushProfile.class, Builder.class);
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
            return new PushProfile();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            if (!getAvatarBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.avatar_);
            }
            if (getCoordsList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(26);
                codedOutputStream.writeUInt32NoTag(this.coordsMemoizedSerializedSize);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.coords_.size()) {
                    break;
                }
                codedOutputStream.writeDoubleNoTag(this.coords_.getDouble(i2));
                i = i2 + 1;
            }
            int i3 = this.vbadge_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(4, i3);
            }
            int i4 = this.online_;
            if (i4 != 0) {
                codedOutputStream.writeInt32(5, i4);
            }
            int i5 = this.friend_;
            if (i5 != 0) {
                codedOutputStream.writeInt32(6, i5);
            }
            int i6 = this.richLevel_;
            if (i6 != 0) {
                codedOutputStream.writeInt32(7, i6);
            }
            int i7 = this.oRichLevel_;
            if (i7 != 0) {
                codedOutputStream.writeInt32(8, i7);
            }
            int i8 = this.vipAnnual_;
            if (i8 != 0) {
                codedOutputStream.writeInt32(9, i8);
            }
            int i9 = this.vipGrade_;
            if (i9 != 0) {
                codedOutputStream.writeInt32(10, i9);
            }
            int i10 = this.vipExpLvl_;
            if (i10 != 0) {
                codedOutputStream.writeInt32(11, i10);
            }
            int i11 = this.oVipGrade_;
            if (i11 != 0) {
                codedOutputStream.writeInt32(12, i11);
            }
            int i12 = this.isHideVipLook_;
            if (i12 != 0) {
                codedOutputStream.writeInt32(14, i12);
            }
            int i13 = this.oIsHideVipLook_;
            if (i13 != 0) {
                codedOutputStream.writeInt32(15, i13);
            }
            if (!getAvatarPendantBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 16, this.avatarPendant_);
            }
            int i14 = this.deviceToken_;
            if (i14 != 0) {
                codedOutputStream.writeInt32(17, i14);
            }
            int i15 = 0;
            if (getShadowCoordsList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(146);
                codedOutputStream.writeUInt32NoTag(this.shadowCoordsMemoizedSerializedSize);
                i15 = 0;
            }
            while (i15 < this.shadowCoords_.size()) {
                codedOutputStream.writeDoubleNoTag(this.shadowCoords_.getDouble(i15));
                i15++;
            }
            int i16 = this.oFaceStatus_;
            if (i16 != 0) {
                codedOutputStream.writeInt32(19, i16);
            }
            int i17 = this.isManager_;
            if (i17 != 0) {
                codedOutputStream.writeInt32(20, i17);
            }
            if (!getPromptTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 21, this.promptType_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PushProfileOuterClass$PushProfileOrBuilder.class */
    public interface PushProfileOrBuilder extends MessageOrBuilder {
        String getAvatar();

        ByteString getAvatarBytes();

        String getAvatarPendant();

        ByteString getAvatarPendantBytes();

        double getCoords(int i);

        int getCoordsCount();

        List<Double> getCoordsList();

        int getDeviceToken();

        int getFriend();

        int getIsHideVipLook();

        int getIsManager();

        String getName();

        ByteString getNameBytes();

        int getOFaceStatus();

        int getOIsHideVipLook();

        int getORichLevel();

        int getOVipGrade();

        int getOnline();

        String getPromptType();

        ByteString getPromptTypeBytes();

        int getRichLevel();

        double getShadowCoords(int i);

        int getShadowCoordsCount();

        List<Double> getShadowCoordsList();

        int getVbadge();

        int getVipAnnual();

        int getVipExpLvl();

        int getVipGrade();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_im_private_chat_PushProfile_descriptor = descriptor2;
        internal_static_com_blued_im_private_chat_PushProfile_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Name", "Avatar", "Coords", "Vbadge", "Online", "Friend", "RichLevel", "ORichLevel", "VipAnnual", "VipGrade", "VipExpLvl", "OVipGrade", "IsHideVipLook", "OIsHideVipLook", "AvatarPendant", "DeviceToken", "ShadowCoords", "OFaceStatus", "IsManager", "PromptType"});
    }

    private PushProfileOuterClass() {
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
