package com.blued.im.private_chat;

import com.blued.im.private_chat.PushBodyExtraOuterClass;
import com.blued.im.private_chat.PushProfileOuterClass;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PushBodyOuterClass.class */
public final class PushBodyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000ePushBody.proto\u0012\u0019com.blued.im.private_chat\u001a\u0011PushProfile.proto\u001a\u0013PushBodyExtra.proto\"¢\u0001\n\bPushBody\u0012\u0010\n\bcontents\u0018\u0001 \u0001(\t\u00127\n\u0007profile\u0018\u0002 \u0001(\u000b2&.com.blued.im.private_chat.PushProfile\u00127\n\u0005extra\u0018\u0003 \u0001(\u000b2(.com.blued.im.private_chat.PushBodyExtra\u0012\u0012\n\nextra_json\u0018\u0004 \u0001(\fB\u000e¢\u0002\u000bPrivateChatb\u0006proto3"}, new Descriptors.FileDescriptor[]{PushProfileOuterClass.getDescriptor(), PushBodyExtraOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_PushBody_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_PushBody_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PushBodyOuterClass$PushBody.class */
    public static final class PushBody extends GeneratedMessageV3 implements PushBodyOrBuilder {
        public static final int CONTENTS_FIELD_NUMBER = 1;
        public static final int EXTRA_FIELD_NUMBER = 3;
        public static final int EXTRA_JSON_FIELD_NUMBER = 4;
        public static final int PROFILE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private volatile Object contents_;
        private ByteString extraJson_;
        private PushBodyExtraOuterClass.PushBodyExtra extra_;
        private byte memoizedIsInitialized;
        private PushProfileOuterClass.PushProfile profile_;
        private static final PushBody DEFAULT_INSTANCE = new PushBody();
        private static final Parser<PushBody> PARSER = new AbstractParser<PushBody>() { // from class: com.blued.im.private_chat.PushBodyOuterClass.PushBody.1
            @Override // com.google.protobuf.Parser
            public PushBody parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PushBody(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PushBodyOuterClass$PushBody$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PushBodyOrBuilder {
            private Object contents_;
            private SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> extraBuilder_;
            private ByteString extraJson_;
            private PushBodyExtraOuterClass.PushBodyExtra extra_;
            private SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> profileBuilder_;
            private PushProfileOuterClass.PushProfile profile_;

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
                return PushBodyOuterClass.internal_static_com_blued_im_private_chat_PushBody_descriptor;
            }

            private SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> getExtraFieldBuilder() {
                if (this.extraBuilder_ == null) {
                    this.extraBuilder_ = new SingleFieldBuilderV3<>(getExtra(), getParentForChildren(), isClean());
                    this.extra_ = null;
                }
                return this.extraBuilder_;
            }

            private SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> getProfileFieldBuilder() {
                if (this.profileBuilder_ == null) {
                    this.profileBuilder_ = new SingleFieldBuilderV3<>(getProfile(), getParentForChildren(), isClean());
                    this.profile_ = null;
                }
                return this.profileBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = PushBody.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PushBody build() {
                PushBody buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PushBody buildPartial() {
                PushBody pushBody = new PushBody(this);
                pushBody.contents_ = this.contents_;
                SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 == null) {
                    pushBody.profile_ = this.profile_;
                } else {
                    pushBody.profile_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> singleFieldBuilderV32 = this.extraBuilder_;
                if (singleFieldBuilderV32 == null) {
                    pushBody.extra_ = this.extra_;
                } else {
                    pushBody.extra_ = singleFieldBuilderV32.build();
                }
                pushBody.extraJson_ = this.extraJson_;
                onBuilt();
                return pushBody;
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
                return this;
            }

            public Builder clearContents() {
                this.contents_ = PushBody.getDefaultInstance().getContents();
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
                this.extraJson_ = PushBody.getDefaultInstance().getExtraJson();
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
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.blued.im.private_chat.PushBodyOuterClass.PushBodyOrBuilder
            public String getContents() {
                Object obj = this.contents_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.contents_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.PushBodyOuterClass.PushBodyOrBuilder
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
            public PushBody getDefaultInstanceForType() {
                return PushBody.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PushBodyOuterClass.internal_static_com_blued_im_private_chat_PushBody_descriptor;
            }

            @Override // com.blued.im.private_chat.PushBodyOuterClass.PushBodyOrBuilder
            public PushBodyExtraOuterClass.PushBodyExtra getExtra() {
                SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra = this.extra_;
                    PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra2 = pushBodyExtra;
                    if (pushBodyExtra == null) {
                        pushBodyExtra2 = PushBodyExtraOuterClass.PushBodyExtra.getDefaultInstance();
                    }
                    return pushBodyExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public PushBodyExtraOuterClass.PushBodyExtra.Builder getExtraBuilder() {
                onChanged();
                return getExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.PushBodyOuterClass.PushBodyOrBuilder
            public ByteString getExtraJson() {
                return this.extraJson_;
            }

            @Override // com.blued.im.private_chat.PushBodyOuterClass.PushBodyOrBuilder
            public PushBodyExtraOuterClass.PushBodyExtraOrBuilder getExtraOrBuilder() {
                SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra = this.extra_;
                PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra2 = pushBodyExtra;
                if (pushBodyExtra == null) {
                    pushBodyExtra2 = PushBodyExtraOuterClass.PushBodyExtra.getDefaultInstance();
                }
                return pushBodyExtra2;
            }

            @Override // com.blued.im.private_chat.PushBodyOuterClass.PushBodyOrBuilder
            public PushProfileOuterClass.PushProfile getProfile() {
                SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 == null) {
                    PushProfileOuterClass.PushProfile pushProfile = this.profile_;
                    PushProfileOuterClass.PushProfile pushProfile2 = pushProfile;
                    if (pushProfile == null) {
                        pushProfile2 = PushProfileOuterClass.PushProfile.getDefaultInstance();
                    }
                    return pushProfile2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public PushProfileOuterClass.PushProfile.Builder getProfileBuilder() {
                onChanged();
                return getProfileFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.PushBodyOuterClass.PushBodyOrBuilder
            public PushProfileOuterClass.PushProfileOrBuilder getProfileOrBuilder() {
                SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                PushProfileOuterClass.PushProfile pushProfile = this.profile_;
                PushProfileOuterClass.PushProfile pushProfile2 = pushProfile;
                if (pushProfile == null) {
                    pushProfile2 = PushProfileOuterClass.PushProfile.getDefaultInstance();
                }
                return pushProfile2;
            }

            @Override // com.blued.im.private_chat.PushBodyOuterClass.PushBodyOrBuilder
            public boolean hasExtra() {
                return (this.extraBuilder_ == null && this.extra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyOuterClass.PushBodyOrBuilder
            public boolean hasProfile() {
                return (this.profileBuilder_ == null && this.profile_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PushBodyOuterClass.internal_static_com_blued_im_private_chat_PushBody_fieldAccessorTable.ensureFieldAccessorsInitialized(PushBody.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeExtra(PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra) {
                SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(pushBodyExtra);
                    return this;
                }
                PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra2 = this.extra_;
                if (pushBodyExtra2 != null) {
                    this.extra_ = PushBodyExtraOuterClass.PushBodyExtra.newBuilder(pushBodyExtra2).mergeFrom(pushBodyExtra).buildPartial();
                } else {
                    this.extra_ = pushBodyExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeFrom(PushBody pushBody) {
                if (pushBody == PushBody.getDefaultInstance()) {
                    return this;
                }
                if (!pushBody.getContents().isEmpty()) {
                    this.contents_ = pushBody.contents_;
                    onChanged();
                }
                if (pushBody.hasProfile()) {
                    mergeProfile(pushBody.getProfile());
                }
                if (pushBody.hasExtra()) {
                    mergeExtra(pushBody.getExtra());
                }
                if (pushBody.getExtraJson() != ByteString.EMPTY) {
                    setExtraJson(pushBody.getExtraJson());
                }
                mergeUnknownFields(pushBody.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.private_chat.PushBodyOuterClass.PushBody.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.private_chat.PushBodyOuterClass.PushBody.access$1100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.private_chat.PushBodyOuterClass$PushBody r0 = (com.blued.im.private_chat.PushBodyOuterClass.PushBody) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.PushBodyOuterClass$PushBody$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.private_chat.PushBodyOuterClass$PushBody r0 = (com.blued.im.private_chat.PushBodyOuterClass.PushBody) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.private_chat.PushBodyOuterClass$PushBody$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.private_chat.PushBodyOuterClass.PushBody.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.private_chat.PushBodyOuterClass$PushBody$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof PushBody) {
                    return mergeFrom((PushBody) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeProfile(PushProfileOuterClass.PushProfile pushProfile) {
                SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(pushProfile);
                    return this;
                }
                PushProfileOuterClass.PushProfile pushProfile2 = this.profile_;
                if (pushProfile2 != null) {
                    this.profile_ = PushProfileOuterClass.PushProfile.newBuilder(pushProfile2).mergeFrom(pushProfile).buildPartial();
                } else {
                    this.profile_ = pushProfile;
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
                    PushBody.checkByteStringIsUtf8(byteString);
                    this.contents_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setExtra(PushBodyExtraOuterClass.PushBodyExtra.Builder builder) {
                SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.extra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setExtra(PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra) {
                SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(pushBodyExtra);
                    return this;
                } else if (pushBodyExtra != null) {
                    this.extra_ = pushBodyExtra;
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

            public Builder setProfile(PushProfileOuterClass.PushProfile.Builder builder) {
                SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.profile_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setProfile(PushProfileOuterClass.PushProfile pushProfile) {
                SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(pushProfile);
                    return this;
                } else if (pushProfile != null) {
                    this.profile_ = pushProfile;
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

        private PushBody() {
            this.memoizedIsInitialized = (byte) -1;
            this.contents_ = "";
            this.extraJson_ = ByteString.EMPTY;
        }

        private PushBody(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                PushProfileOuterClass.PushProfile.Builder builder = this.profile_ != null ? this.profile_.toBuilder() : null;
                                PushProfileOuterClass.PushProfile pushProfile = (PushProfileOuterClass.PushProfile) codedInputStream.readMessage(PushProfileOuterClass.PushProfile.parser(), extensionRegistryLite);
                                this.profile_ = pushProfile;
                                if (builder != null) {
                                    builder.mergeFrom(pushProfile);
                                    this.profile_ = builder.buildPartial();
                                }
                            } else if (readTag == 26) {
                                PushBodyExtraOuterClass.PushBodyExtra.Builder builder2 = this.extra_ != null ? this.extra_.toBuilder() : null;
                                PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra = (PushBodyExtraOuterClass.PushBodyExtra) codedInputStream.readMessage(PushBodyExtraOuterClass.PushBodyExtra.parser(), extensionRegistryLite);
                                this.extra_ = pushBodyExtra;
                                if (builder2 != null) {
                                    builder2.mergeFrom(pushBodyExtra);
                                    this.extra_ = builder2.buildPartial();
                                }
                            } else if (readTag == 34) {
                                this.extraJson_ = codedInputStream.readBytes();
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

        private PushBody(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static PushBody getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PushBodyOuterClass.internal_static_com_blued_im_private_chat_PushBody_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PushBody pushBody) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(pushBody);
        }

        public static PushBody parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PushBody) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static PushBody parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PushBody) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PushBody parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static PushBody parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static PushBody parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PushBody) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static PushBody parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PushBody) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static PushBody parseFrom(InputStream inputStream) throws IOException {
            return (PushBody) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static PushBody parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PushBody) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PushBody parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static PushBody parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static PushBody parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static PushBody parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<PushBody> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof PushBody) {
                PushBody pushBody = (PushBody) obj;
                if (getContents().equals(pushBody.getContents()) && hasProfile() == pushBody.hasProfile()) {
                    if ((!hasProfile() || getProfile().equals(pushBody.getProfile())) && hasExtra() == pushBody.hasExtra()) {
                        return (!hasExtra() || getExtra().equals(pushBody.getExtra())) && getExtraJson().equals(pushBody.getExtraJson()) && this.unknownFields.equals(pushBody.unknownFields);
                    }
                    return false;
                }
                return false;
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.private_chat.PushBodyOuterClass.PushBodyOrBuilder
        public String getContents() {
            Object obj = this.contents_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.contents_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.PushBodyOuterClass.PushBodyOrBuilder
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
        public PushBody getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.private_chat.PushBodyOuterClass.PushBodyOrBuilder
        public PushBodyExtraOuterClass.PushBodyExtra getExtra() {
            PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra = this.extra_;
            PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra2 = pushBodyExtra;
            if (pushBodyExtra == null) {
                pushBodyExtra2 = PushBodyExtraOuterClass.PushBodyExtra.getDefaultInstance();
            }
            return pushBodyExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyOuterClass.PushBodyOrBuilder
        public ByteString getExtraJson() {
            return this.extraJson_;
        }

        @Override // com.blued.im.private_chat.PushBodyOuterClass.PushBodyOrBuilder
        public PushBodyExtraOuterClass.PushBodyExtraOrBuilder getExtraOrBuilder() {
            return getExtra();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PushBody> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.private_chat.PushBodyOuterClass.PushBodyOrBuilder
        public PushProfileOuterClass.PushProfile getProfile() {
            PushProfileOuterClass.PushProfile pushProfile = this.profile_;
            PushProfileOuterClass.PushProfile pushProfile2 = pushProfile;
            if (pushProfile == null) {
                pushProfile2 = PushProfileOuterClass.PushProfile.getDefaultInstance();
            }
            return pushProfile2;
        }

        @Override // com.blued.im.private_chat.PushBodyOuterClass.PushBodyOrBuilder
        public PushProfileOuterClass.PushProfileOrBuilder getProfileOrBuilder() {
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
            int serializedSize = i5 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.im.private_chat.PushBodyOuterClass.PushBodyOrBuilder
        public boolean hasExtra() {
            return this.extra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyOuterClass.PushBodyOrBuilder
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
            int hashCode2 = (((((i2 * 37) + 4) * 53) + getExtraJson().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PushBodyOuterClass.internal_static_com_blued_im_private_chat_PushBody_fieldAccessorTable.ensureFieldAccessorsInitialized(PushBody.class, Builder.class);
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
            return new PushBody();
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
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PushBodyOuterClass$PushBodyOrBuilder.class */
    public interface PushBodyOrBuilder extends MessageOrBuilder {
        String getContents();

        ByteString getContentsBytes();

        PushBodyExtraOuterClass.PushBodyExtra getExtra();

        ByteString getExtraJson();

        PushBodyExtraOuterClass.PushBodyExtraOrBuilder getExtraOrBuilder();

        PushProfileOuterClass.PushProfile getProfile();

        PushProfileOuterClass.PushProfileOrBuilder getProfileOrBuilder();

        boolean hasExtra();

        boolean hasProfile();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_im_private_chat_PushBody_descriptor = descriptor2;
        internal_static_com_blued_im_private_chat_PushBody_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Contents", "Profile", "Extra", "ExtraJson"});
        PushProfileOuterClass.getDescriptor();
        PushBodyExtraOuterClass.getDescriptor();
    }

    private PushBodyOuterClass() {
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
