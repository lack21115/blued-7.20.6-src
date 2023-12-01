package com.blued.das.authority;

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

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/authority/SystemAuthorityProtos.class */
public final class SystemAuthorityProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bSystemAuthorityProtos.proto\u0012\u0017com.blued.das.authority\"Ã\u0001\n\u0014SystemAuthorityProto\u0012-\n\u0005event\u0018\u0001 \u0001(\u000e2\u001e.com.blued.das.authority.Event\u0012+\n\u0004type\u0018\u0002 \u0001(\u000e2\u001d.com.blued.das.authority.Type\u0012\u000f\n\u0007is_open\u0018\u0003 \u0001(\b\u0012\u000b\n\u0003url\u0018\u0004 \u0001(\t\u0012\u000f\n\u0007content\u0018\u0005 \u0001(\t\u0012\r\n\u0005token\u0018\u0006 \u0001(\t\u0012\u0011\n\tclient_id\u0018\u0007 \u0001(\t*È\u0002\n\u0005Event\u0012\u0011\n\rUNKNOWN_EVENT\u0010��\u0012\u0014\n\u0010SYSTEM_AUTHORITY\u0010\u0001\u0012\u0017\n\u0013IOS_SCREENSHOT_SHOW\u0010\u0002\u0012\u0016\n\u0012IOS_AUTHENTICATION\u0010\u0003\u0012\u001a\n\u0016PHONE_CONFIRM_POP_SHOW\u0010\u0004\u0012\u001b\n\u0017PHONE_CONFIRM_USE_CLICK\u0010\u0005\u0012\u001e\n\u001aPHONE_CONFIRM_CHANGE_CLICK\u0010\u0006\u0012\u0011\n\rPUSH_RECEIVED\u0010\u0007\u0012\u000e\n\nPUSH_CLICK\u0010\b\u0012\u0015\n\u0011PUSH_MSG_NAVIGATE\u0010\t\u0012\u0018\n\u0014SPECIAL_WAY_OPEN_APP\u0010\n\u0012\u0015\n\u0011AUTHORITY_REQUIRE\u0010\u000b\u0012\r\n\tAPP_START\u0010\f\u0012\u0012\n\u000eAPP_GETUI_PUSH\u0010\r*0\n\u0004Type\u0012\u0010\n\fUNKNOWN_TYPE\u0010��\u0012\b\n\u0004PUSH\u0010\u0001\u0012\f\n\bLOCATION\u0010\u0002B\u0013¢\u0002\u0010SYSTEM_AUTHORITYb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_blued_das_authority_SystemAuthorityProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_authority_SystemAuthorityProto_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/authority/SystemAuthorityProtos$Event.class */
    public enum Event implements ProtocolMessageEnum {
        UNKNOWN_EVENT(0),
        SYSTEM_AUTHORITY(1),
        IOS_SCREENSHOT_SHOW(2),
        IOS_AUTHENTICATION(3),
        PHONE_CONFIRM_POP_SHOW(4),
        PHONE_CONFIRM_USE_CLICK(5),
        PHONE_CONFIRM_CHANGE_CLICK(6),
        PUSH_RECEIVED(7),
        PUSH_CLICK(8),
        PUSH_MSG_NAVIGATE(9),
        SPECIAL_WAY_OPEN_APP(10),
        AUTHORITY_REQUIRE(11),
        APP_START(12),
        APP_GETUI_PUSH(13),
        UNRECOGNIZED(-1);
        
        public static final int APP_GETUI_PUSH_VALUE = 13;
        public static final int APP_START_VALUE = 12;
        public static final int AUTHORITY_REQUIRE_VALUE = 11;
        public static final int IOS_AUTHENTICATION_VALUE = 3;
        public static final int IOS_SCREENSHOT_SHOW_VALUE = 2;
        public static final int PHONE_CONFIRM_CHANGE_CLICK_VALUE = 6;
        public static final int PHONE_CONFIRM_POP_SHOW_VALUE = 4;
        public static final int PHONE_CONFIRM_USE_CLICK_VALUE = 5;
        public static final int PUSH_CLICK_VALUE = 8;
        public static final int PUSH_MSG_NAVIGATE_VALUE = 9;
        public static final int PUSH_RECEIVED_VALUE = 7;
        public static final int SPECIAL_WAY_OPEN_APP_VALUE = 10;
        public static final int SYSTEM_AUTHORITY_VALUE = 1;
        public static final int UNKNOWN_EVENT_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<Event> internalValueMap = new Internal.EnumLiteMap<Event>() { // from class: com.blued.das.authority.SystemAuthorityProtos.Event.1
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
                    return SYSTEM_AUTHORITY;
                case 2:
                    return IOS_SCREENSHOT_SHOW;
                case 3:
                    return IOS_AUTHENTICATION;
                case 4:
                    return PHONE_CONFIRM_POP_SHOW;
                case 5:
                    return PHONE_CONFIRM_USE_CLICK;
                case 6:
                    return PHONE_CONFIRM_CHANGE_CLICK;
                case 7:
                    return PUSH_RECEIVED;
                case 8:
                    return PUSH_CLICK;
                case 9:
                    return PUSH_MSG_NAVIGATE;
                case 10:
                    return SPECIAL_WAY_OPEN_APP;
                case 11:
                    return AUTHORITY_REQUIRE;
                case 12:
                    return APP_START;
                case 13:
                    return APP_GETUI_PUSH;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return SystemAuthorityProtos.getDescriptor().getEnumTypes().get(0);
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/authority/SystemAuthorityProtos$SystemAuthorityProto.class */
    public static final class SystemAuthorityProto extends GeneratedMessageV3 implements SystemAuthorityProtoOrBuilder {
        public static final int CLIENT_ID_FIELD_NUMBER = 7;
        public static final int CONTENT_FIELD_NUMBER = 5;
        public static final int EVENT_FIELD_NUMBER = 1;
        public static final int IS_OPEN_FIELD_NUMBER = 3;
        public static final int TOKEN_FIELD_NUMBER = 6;
        public static final int TYPE_FIELD_NUMBER = 2;
        public static final int URL_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private volatile Object clientId_;
        private volatile Object content_;
        private int event_;
        private boolean isOpen_;
        private byte memoizedIsInitialized;
        private volatile Object token_;
        private int type_;
        private volatile Object url_;
        private static final SystemAuthorityProto DEFAULT_INSTANCE = new SystemAuthorityProto();
        private static final Parser<SystemAuthorityProto> PARSER = new AbstractParser<SystemAuthorityProto>() { // from class: com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProto.1
            @Override // com.google.protobuf.Parser
            public SystemAuthorityProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SystemAuthorityProto(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/authority/SystemAuthorityProtos$SystemAuthorityProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SystemAuthorityProtoOrBuilder {
            private Object clientId_;
            private Object content_;
            private int event_;
            private boolean isOpen_;
            private Object token_;
            private int type_;
            private Object url_;

            private Builder() {
                this.event_ = 0;
                this.type_ = 0;
                this.url_ = "";
                this.content_ = "";
                this.token_ = "";
                this.clientId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.event_ = 0;
                this.type_ = 0;
                this.url_ = "";
                this.content_ = "";
                this.token_ = "";
                this.clientId_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SystemAuthorityProtos.internal_static_com_blued_das_authority_SystemAuthorityProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = SystemAuthorityProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SystemAuthorityProto build() {
                SystemAuthorityProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SystemAuthorityProto buildPartial() {
                SystemAuthorityProto systemAuthorityProto = new SystemAuthorityProto(this);
                systemAuthorityProto.event_ = this.event_;
                systemAuthorityProto.type_ = this.type_;
                systemAuthorityProto.isOpen_ = this.isOpen_;
                systemAuthorityProto.url_ = this.url_;
                systemAuthorityProto.content_ = this.content_;
                systemAuthorityProto.token_ = this.token_;
                systemAuthorityProto.clientId_ = this.clientId_;
                onBuilt();
                return systemAuthorityProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.event_ = 0;
                this.type_ = 0;
                this.isOpen_ = false;
                this.url_ = "";
                this.content_ = "";
                this.token_ = "";
                this.clientId_ = "";
                return this;
            }

            public Builder clearClientId() {
                this.clientId_ = SystemAuthorityProto.getDefaultInstance().getClientId();
                onChanged();
                return this;
            }

            public Builder clearContent() {
                this.content_ = SystemAuthorityProto.getDefaultInstance().getContent();
                onChanged();
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

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearToken() {
                this.token_ = SystemAuthorityProto.getDefaultInstance().getToken();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            public Builder clearUrl() {
                this.url_ = SystemAuthorityProto.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
            public String getClientId() {
                Object obj = this.clientId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.clientId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
            public ByteString getClientIdBytes() {
                Object obj = this.clientId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.clientId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
            public String getContent() {
                Object obj = this.content_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.content_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
            public ByteString getContentBytes() {
                Object obj = this.content_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.content_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SystemAuthorityProto getDefaultInstanceForType() {
                return SystemAuthorityProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SystemAuthorityProtos.internal_static_com_blued_das_authority_SystemAuthorityProto_descriptor;
            }

            @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
            public Event getEvent() {
                Event valueOf = Event.valueOf(this.event_);
                Event event = valueOf;
                if (valueOf == null) {
                    event = Event.UNRECOGNIZED;
                }
                return event;
            }

            @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
            public int getEventValue() {
                return this.event_;
            }

            @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
            public String getToken() {
                Object obj = this.token_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.token_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
            public ByteString getTokenBytes() {
                Object obj = this.token_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.token_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
            public Type getType() {
                Type valueOf = Type.valueOf(this.type_);
                Type type = valueOf;
                if (valueOf == null) {
                    type = Type.UNRECOGNIZED;
                }
                return type;
            }

            @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
            public String getUrl() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
            public ByteString getUrlBytes() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.url_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SystemAuthorityProtos.internal_static_com_blued_das_authority_SystemAuthorityProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SystemAuthorityProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(SystemAuthorityProto systemAuthorityProto) {
                if (systemAuthorityProto == SystemAuthorityProto.getDefaultInstance()) {
                    return this;
                }
                if (systemAuthorityProto.event_ != 0) {
                    setEventValue(systemAuthorityProto.getEventValue());
                }
                if (systemAuthorityProto.type_ != 0) {
                    setTypeValue(systemAuthorityProto.getTypeValue());
                }
                if (systemAuthorityProto.getIsOpen()) {
                    setIsOpen(systemAuthorityProto.getIsOpen());
                }
                if (!systemAuthorityProto.getUrl().isEmpty()) {
                    this.url_ = systemAuthorityProto.url_;
                    onChanged();
                }
                if (!systemAuthorityProto.getContent().isEmpty()) {
                    this.content_ = systemAuthorityProto.content_;
                    onChanged();
                }
                if (!systemAuthorityProto.getToken().isEmpty()) {
                    this.token_ = systemAuthorityProto.token_;
                    onChanged();
                }
                if (!systemAuthorityProto.getClientId().isEmpty()) {
                    this.clientId_ = systemAuthorityProto.clientId_;
                    onChanged();
                }
                mergeUnknownFields(systemAuthorityProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProto.access$1400()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.authority.SystemAuthorityProtos$SystemAuthorityProto r0 = (com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.authority.SystemAuthorityProtos$SystemAuthorityProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.authority.SystemAuthorityProtos$SystemAuthorityProto r0 = (com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.authority.SystemAuthorityProtos$SystemAuthorityProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.authority.SystemAuthorityProtos$SystemAuthorityProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof SystemAuthorityProto) {
                    return mergeFrom((SystemAuthorityProto) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setClientId(String str) {
                if (str != null) {
                    this.clientId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setClientIdBytes(ByteString byteString) {
                if (byteString != null) {
                    SystemAuthorityProto.checkByteStringIsUtf8(byteString);
                    this.clientId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setContent(String str) {
                if (str != null) {
                    this.content_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setContentBytes(ByteString byteString) {
                if (byteString != null) {
                    SystemAuthorityProto.checkByteStringIsUtf8(byteString);
                    this.content_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
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

            public Builder setIsOpen(boolean z) {
                this.isOpen_ = z;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setToken(String str) {
                if (str != null) {
                    this.token_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTokenBytes(ByteString byteString) {
                if (byteString != null) {
                    SystemAuthorityProto.checkByteStringIsUtf8(byteString);
                    this.token_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setType(Type type) {
                if (type != null) {
                    this.type_ = type.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTypeValue(int i) {
                this.type_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public Builder setUrl(String str) {
                if (str != null) {
                    this.url_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setUrlBytes(ByteString byteString) {
                if (byteString != null) {
                    SystemAuthorityProto.checkByteStringIsUtf8(byteString);
                    this.url_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }
        }

        private SystemAuthorityProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.event_ = 0;
            this.type_ = 0;
            this.url_ = "";
            this.content_ = "";
            this.token_ = "";
            this.clientId_ = "";
        }

        private SystemAuthorityProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.type_ = codedInputStream.readEnum();
                                } else if (readTag == 24) {
                                    this.isOpen_ = codedInputStream.readBool();
                                } else if (readTag == 34) {
                                    this.url_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 42) {
                                    this.content_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 50) {
                                    this.token_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 58) {
                                    this.clientId_ = codedInputStream.readStringRequireUtf8();
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

        private SystemAuthorityProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SystemAuthorityProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SystemAuthorityProtos.internal_static_com_blued_das_authority_SystemAuthorityProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SystemAuthorityProto systemAuthorityProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(systemAuthorityProto);
        }

        public static SystemAuthorityProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SystemAuthorityProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SystemAuthorityProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SystemAuthorityProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SystemAuthorityProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static SystemAuthorityProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static SystemAuthorityProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SystemAuthorityProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static SystemAuthorityProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SystemAuthorityProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static SystemAuthorityProto parseFrom(InputStream inputStream) throws IOException {
            return (SystemAuthorityProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SystemAuthorityProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SystemAuthorityProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SystemAuthorityProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static SystemAuthorityProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static SystemAuthorityProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static SystemAuthorityProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<SystemAuthorityProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof SystemAuthorityProto) {
                SystemAuthorityProto systemAuthorityProto = (SystemAuthorityProto) obj;
                return this.event_ == systemAuthorityProto.event_ && this.type_ == systemAuthorityProto.type_ && getIsOpen() == systemAuthorityProto.getIsOpen() && getUrl().equals(systemAuthorityProto.getUrl()) && getContent().equals(systemAuthorityProto.getContent()) && getToken().equals(systemAuthorityProto.getToken()) && getClientId().equals(systemAuthorityProto.getClientId()) && this.unknownFields.equals(systemAuthorityProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
        public String getClientId() {
            Object obj = this.clientId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.clientId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
        public ByteString getClientIdBytes() {
            Object obj = this.clientId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.clientId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
        public String getContent() {
            Object obj = this.content_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.content_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
        public ByteString getContentBytes() {
            Object obj = this.content_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.content_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SystemAuthorityProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
        public Event getEvent() {
            Event valueOf = Event.valueOf(this.event_);
            Event event = valueOf;
            if (valueOf == null) {
                event = Event.UNRECOGNIZED;
            }
            return event;
        }

        @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
        public int getEventValue() {
            return this.event_;
        }

        @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SystemAuthorityProto> getParserForType() {
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
            if (this.type_ != Type.UNKNOWN_TYPE.getNumber()) {
                i3 = i2 + CodedOutputStream.computeEnumSize(2, this.type_);
            }
            boolean z = this.isOpen_;
            int i4 = i3;
            if (z) {
                i4 = i3 + CodedOutputStream.computeBoolSize(3, z);
            }
            int i5 = i4;
            if (!getUrlBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(4, this.url_);
            }
            int i6 = i5;
            if (!getContentBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(5, this.content_);
            }
            int i7 = i6;
            if (!getTokenBytes().isEmpty()) {
                i7 = i6 + GeneratedMessageV3.computeStringSize(6, this.token_);
            }
            int i8 = i7;
            if (!getClientIdBytes().isEmpty()) {
                i8 = i7 + GeneratedMessageV3.computeStringSize(7, this.clientId_);
            }
            int serializedSize = i8 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
        public String getToken() {
            Object obj = this.token_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.token_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
        public ByteString getTokenBytes() {
            Object obj = this.token_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.token_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
        public Type getType() {
            Type valueOf = Type.valueOf(this.type_);
            Type type = valueOf;
            if (valueOf == null) {
                type = Type.UNRECOGNIZED;
            }
            return type;
        }

        @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.authority.SystemAuthorityProtos.SystemAuthorityProtoOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.event_) * 37) + 2) * 53) + this.type_) * 37) + 3) * 53) + Internal.hashBoolean(getIsOpen())) * 37) + 4) * 53) + getUrl().hashCode()) * 37) + 5) * 53) + getContent().hashCode()) * 37) + 6) * 53) + getToken().hashCode()) * 37) + 7) * 53) + getClientId().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SystemAuthorityProtos.internal_static_com_blued_das_authority_SystemAuthorityProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SystemAuthorityProto.class, Builder.class);
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
            return new SystemAuthorityProto();
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
            if (this.type_ != Type.UNKNOWN_TYPE.getNumber()) {
                codedOutputStream.writeEnum(2, this.type_);
            }
            boolean z = this.isOpen_;
            if (z) {
                codedOutputStream.writeBool(3, z);
            }
            if (!getUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.url_);
            }
            if (!getContentBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.content_);
            }
            if (!getTokenBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.token_);
            }
            if (!getClientIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.clientId_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/authority/SystemAuthorityProtos$SystemAuthorityProtoOrBuilder.class */
    public interface SystemAuthorityProtoOrBuilder extends MessageOrBuilder {
        String getClientId();

        ByteString getClientIdBytes();

        String getContent();

        ByteString getContentBytes();

        Event getEvent();

        int getEventValue();

        boolean getIsOpen();

        String getToken();

        ByteString getTokenBytes();

        Type getType();

        int getTypeValue();

        String getUrl();

        ByteString getUrlBytes();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/authority/SystemAuthorityProtos$Type.class */
    public enum Type implements ProtocolMessageEnum {
        UNKNOWN_TYPE(0),
        PUSH(1),
        LOCATION(2),
        UNRECOGNIZED(-1);
        
        public static final int LOCATION_VALUE = 2;
        public static final int PUSH_VALUE = 1;
        public static final int UNKNOWN_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<Type> internalValueMap = new Internal.EnumLiteMap<Type>() { // from class: com.blued.das.authority.SystemAuthorityProtos.Type.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Type findValueByNumber(int i) {
                return Type.forNumber(i);
            }
        };
        private static final Type[] VALUES = values();

        Type(int i) {
            this.value = i;
        }

        public static Type forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return LOCATION;
                }
                return PUSH;
            }
            return UNKNOWN_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return SystemAuthorityProtos.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<Type> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Type valueOf(int i) {
            return forNumber(i);
        }

        public static Type valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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
        internal_static_com_blued_das_authority_SystemAuthorityProto_descriptor = descriptor2;
        internal_static_com_blued_das_authority_SystemAuthorityProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Event", "Type", "IsOpen", "Url", "Content", "Token", "ClientId"});
    }

    private SystemAuthorityProtos() {
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
