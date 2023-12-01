package com.blued.das;

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

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/CommonProtos.class */
public final class CommonProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012CommonProtos.proto\u0012\rcom.blued.das\"\u009f\u0004\n\u0006Common\u0012\u000e\n\u0006net_op\u0018\u0001 \u0001(\t\u0012\u000b\n\u0003net\u0018\u0002 \u0001(\t\u0012\u000b\n\u0003lat\u0018\u0003 \u0001(\t\u0012\u000b\n\u0003lon\u0018\u0004 \u0001(\t\u0012\u000f\n\u0007channel\u0018\u0005 \u0001(\t\u0012\u000b\n\u0003uid\u0018\u0006 \u0001(\u0003\u0012\u0010\n\bplatform\u0018\u0007 \u0001(\t\u0012\u0013\n\u000bapp_version\u0018\b \u0001(\t\u0012\u0014\n\fscreen_width\u0018\t \u0001(\u0005\u0012\u0013\n\u000bscreen_high\u0018\n \u0001(\u0005\u0012\u0012\n\nos_version\u0018\u000b \u0001(\t\u0012\u000e\n\u0006device\u0018\f \u0001(\t\u0012\u0011\n\tclient_ip\u0018\r \u0001(\t\u0012\f\n\u0004imei\u0018\u000e \u0001(\t\u0012\f\n\u0004idfa\u0018\u000f \u0001(\t\u0012\f\n\u0004smid\u0018\u0010 \u0001(\t\u0012\u000f\n\u0007dev_dna\u0018\u0011 \u0001(\t\u0012\u0010\n\btimezone\u0018\u0012 \u0001(\t\u0012\u0012\n\nrequest_id\u0018\u0013 \u0001(\t\u0012\u0011\n\tserver_ip\u0018\u0014 \u0001(\t\u0012\u000f\n\u0007uid_str\u0018\u0015 \u0001(\t\u0012\u0010\n\blanguage\u0018\u0016 \u0001(\t\u0012\u000e\n\u0006region\u0018\u0017 \u0001(\t\u0012\f\n\u0004idfv\u0018\u0018 \u0001(\t\u0012\u0010\n\bvip_type\u0018\u0019 \u0001(\t\u0012\u0018\n\u0010app_version_code\u0018\u001a \u0001(\u0005\u0012\u0010\n\bapp_type\u0018\u001b \u0001(\t\u0012\u000e\n\u0006box_id\u0018\u001c \u0001(\t\u0012\u0018\n\u0010sdk_version_code\u0018\u001d \u0001(\u0005\u0012\f\n\u0004aaid\u0018\u001e \u0001(\t\u0012\f\n\u0004oaid\u0018\u001f \u0001(\tB\t¢\u0002\u0006Commonb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_blued_das_Common_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_Common_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/CommonProtos$Common.class */
    public static final class Common extends GeneratedMessageV3 implements CommonOrBuilder {
        public static final int AAID_FIELD_NUMBER = 30;
        public static final int APP_TYPE_FIELD_NUMBER = 27;
        public static final int APP_VERSION_CODE_FIELD_NUMBER = 26;
        public static final int APP_VERSION_FIELD_NUMBER = 8;
        public static final int BOX_ID_FIELD_NUMBER = 28;
        public static final int CHANNEL_FIELD_NUMBER = 5;
        public static final int CLIENT_IP_FIELD_NUMBER = 13;
        public static final int DEVICE_FIELD_NUMBER = 12;
        public static final int DEV_DNA_FIELD_NUMBER = 17;
        public static final int IDFA_FIELD_NUMBER = 15;
        public static final int IDFV_FIELD_NUMBER = 24;
        public static final int IMEI_FIELD_NUMBER = 14;
        public static final int LANGUAGE_FIELD_NUMBER = 22;
        public static final int LAT_FIELD_NUMBER = 3;
        public static final int LON_FIELD_NUMBER = 4;
        public static final int NET_FIELD_NUMBER = 2;
        public static final int NET_OP_FIELD_NUMBER = 1;
        public static final int OAID_FIELD_NUMBER = 31;
        public static final int OS_VERSION_FIELD_NUMBER = 11;
        public static final int PLATFORM_FIELD_NUMBER = 7;
        public static final int REGION_FIELD_NUMBER = 23;
        public static final int REQUEST_ID_FIELD_NUMBER = 19;
        public static final int SCREEN_HIGH_FIELD_NUMBER = 10;
        public static final int SCREEN_WIDTH_FIELD_NUMBER = 9;
        public static final int SDK_VERSION_CODE_FIELD_NUMBER = 29;
        public static final int SERVER_IP_FIELD_NUMBER = 20;
        public static final int SMID_FIELD_NUMBER = 16;
        public static final int TIMEZONE_FIELD_NUMBER = 18;
        public static final int UID_FIELD_NUMBER = 6;
        public static final int UID_STR_FIELD_NUMBER = 21;
        public static final int VIP_TYPE_FIELD_NUMBER = 25;
        private static final long serialVersionUID = 0;
        private volatile Object aaid_;
        private volatile Object appType_;
        private int appVersionCode_;
        private volatile Object appVersion_;
        private volatile Object boxId_;
        private volatile Object channel_;
        private volatile Object clientIp_;
        private volatile Object devDna_;
        private volatile Object device_;
        private volatile Object idfa_;
        private volatile Object idfv_;
        private volatile Object imei_;
        private volatile Object language_;
        private volatile Object lat_;
        private volatile Object lon_;
        private byte memoizedIsInitialized;
        private volatile Object netOp_;
        private volatile Object net_;
        private volatile Object oaid_;
        private volatile Object osVersion_;
        private volatile Object platform_;
        private volatile Object region_;
        private volatile Object requestId_;
        private int screenHigh_;
        private int screenWidth_;
        private int sdkVersionCode_;
        private volatile Object serverIp_;
        private volatile Object smid_;
        private volatile Object timezone_;
        private volatile Object uidStr_;
        private long uid_;
        private volatile Object vipType_;
        private static final Common DEFAULT_INSTANCE = new Common();
        private static final Parser<Common> PARSER = new AbstractParser<Common>() { // from class: com.blued.das.CommonProtos.Common.1
            @Override // com.google.protobuf.Parser
            public Common parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Common(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/CommonProtos$Common$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CommonOrBuilder {
            private Object aaid_;
            private Object appType_;
            private int appVersionCode_;
            private Object appVersion_;
            private Object boxId_;
            private Object channel_;
            private Object clientIp_;
            private Object devDna_;
            private Object device_;
            private Object idfa_;
            private Object idfv_;
            private Object imei_;
            private Object language_;
            private Object lat_;
            private Object lon_;
            private Object netOp_;
            private Object net_;
            private Object oaid_;
            private Object osVersion_;
            private Object platform_;
            private Object region_;
            private Object requestId_;
            private int screenHigh_;
            private int screenWidth_;
            private int sdkVersionCode_;
            private Object serverIp_;
            private Object smid_;
            private Object timezone_;
            private Object uidStr_;
            private long uid_;
            private Object vipType_;

            private Builder() {
                this.netOp_ = "";
                this.net_ = "";
                this.lat_ = "";
                this.lon_ = "";
                this.channel_ = "";
                this.platform_ = "";
                this.appVersion_ = "";
                this.osVersion_ = "";
                this.device_ = "";
                this.clientIp_ = "";
                this.imei_ = "";
                this.idfa_ = "";
                this.smid_ = "";
                this.devDna_ = "";
                this.timezone_ = "";
                this.requestId_ = "";
                this.serverIp_ = "";
                this.uidStr_ = "";
                this.language_ = "";
                this.region_ = "";
                this.idfv_ = "";
                this.vipType_ = "";
                this.appType_ = "";
                this.boxId_ = "";
                this.aaid_ = "";
                this.oaid_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.netOp_ = "";
                this.net_ = "";
                this.lat_ = "";
                this.lon_ = "";
                this.channel_ = "";
                this.platform_ = "";
                this.appVersion_ = "";
                this.osVersion_ = "";
                this.device_ = "";
                this.clientIp_ = "";
                this.imei_ = "";
                this.idfa_ = "";
                this.smid_ = "";
                this.devDna_ = "";
                this.timezone_ = "";
                this.requestId_ = "";
                this.serverIp_ = "";
                this.uidStr_ = "";
                this.language_ = "";
                this.region_ = "";
                this.idfv_ = "";
                this.vipType_ = "";
                this.appType_ = "";
                this.boxId_ = "";
                this.aaid_ = "";
                this.oaid_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return CommonProtos.internal_static_com_blued_das_Common_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Common.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Common build() {
                Common buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Common buildPartial() {
                Common common = new Common(this);
                common.netOp_ = this.netOp_;
                common.net_ = this.net_;
                common.lat_ = this.lat_;
                common.lon_ = this.lon_;
                common.channel_ = this.channel_;
                common.uid_ = this.uid_;
                common.platform_ = this.platform_;
                common.appVersion_ = this.appVersion_;
                common.screenWidth_ = this.screenWidth_;
                common.screenHigh_ = this.screenHigh_;
                common.osVersion_ = this.osVersion_;
                common.device_ = this.device_;
                common.clientIp_ = this.clientIp_;
                common.imei_ = this.imei_;
                common.idfa_ = this.idfa_;
                common.smid_ = this.smid_;
                common.devDna_ = this.devDna_;
                common.timezone_ = this.timezone_;
                common.requestId_ = this.requestId_;
                common.serverIp_ = this.serverIp_;
                common.uidStr_ = this.uidStr_;
                common.language_ = this.language_;
                common.region_ = this.region_;
                common.idfv_ = this.idfv_;
                common.vipType_ = this.vipType_;
                common.appVersionCode_ = this.appVersionCode_;
                common.appType_ = this.appType_;
                common.boxId_ = this.boxId_;
                common.sdkVersionCode_ = this.sdkVersionCode_;
                common.aaid_ = this.aaid_;
                common.oaid_ = this.oaid_;
                onBuilt();
                return common;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.netOp_ = "";
                this.net_ = "";
                this.lat_ = "";
                this.lon_ = "";
                this.channel_ = "";
                this.uid_ = 0L;
                this.platform_ = "";
                this.appVersion_ = "";
                this.screenWidth_ = 0;
                this.screenHigh_ = 0;
                this.osVersion_ = "";
                this.device_ = "";
                this.clientIp_ = "";
                this.imei_ = "";
                this.idfa_ = "";
                this.smid_ = "";
                this.devDna_ = "";
                this.timezone_ = "";
                this.requestId_ = "";
                this.serverIp_ = "";
                this.uidStr_ = "";
                this.language_ = "";
                this.region_ = "";
                this.idfv_ = "";
                this.vipType_ = "";
                this.appVersionCode_ = 0;
                this.appType_ = "";
                this.boxId_ = "";
                this.sdkVersionCode_ = 0;
                this.aaid_ = "";
                this.oaid_ = "";
                return this;
            }

            public Builder clearAaid() {
                this.aaid_ = Common.getDefaultInstance().getAaid();
                onChanged();
                return this;
            }

            public Builder clearAppType() {
                this.appType_ = Common.getDefaultInstance().getAppType();
                onChanged();
                return this;
            }

            public Builder clearAppVersion() {
                this.appVersion_ = Common.getDefaultInstance().getAppVersion();
                onChanged();
                return this;
            }

            public Builder clearAppVersionCode() {
                this.appVersionCode_ = 0;
                onChanged();
                return this;
            }

            public Builder clearBoxId() {
                this.boxId_ = Common.getDefaultInstance().getBoxId();
                onChanged();
                return this;
            }

            public Builder clearChannel() {
                this.channel_ = Common.getDefaultInstance().getChannel();
                onChanged();
                return this;
            }

            public Builder clearClientIp() {
                this.clientIp_ = Common.getDefaultInstance().getClientIp();
                onChanged();
                return this;
            }

            public Builder clearDevDna() {
                this.devDna_ = Common.getDefaultInstance().getDevDna();
                onChanged();
                return this;
            }

            public Builder clearDevice() {
                this.device_ = Common.getDefaultInstance().getDevice();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearIdfa() {
                this.idfa_ = Common.getDefaultInstance().getIdfa();
                onChanged();
                return this;
            }

            public Builder clearIdfv() {
                this.idfv_ = Common.getDefaultInstance().getIdfv();
                onChanged();
                return this;
            }

            public Builder clearImei() {
                this.imei_ = Common.getDefaultInstance().getImei();
                onChanged();
                return this;
            }

            public Builder clearLanguage() {
                this.language_ = Common.getDefaultInstance().getLanguage();
                onChanged();
                return this;
            }

            public Builder clearLat() {
                this.lat_ = Common.getDefaultInstance().getLat();
                onChanged();
                return this;
            }

            public Builder clearLon() {
                this.lon_ = Common.getDefaultInstance().getLon();
                onChanged();
                return this;
            }

            public Builder clearNet() {
                this.net_ = Common.getDefaultInstance().getNet();
                onChanged();
                return this;
            }

            public Builder clearNetOp() {
                this.netOp_ = Common.getDefaultInstance().getNetOp();
                onChanged();
                return this;
            }

            public Builder clearOaid() {
                this.oaid_ = Common.getDefaultInstance().getOaid();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearOsVersion() {
                this.osVersion_ = Common.getDefaultInstance().getOsVersion();
                onChanged();
                return this;
            }

            public Builder clearPlatform() {
                this.platform_ = Common.getDefaultInstance().getPlatform();
                onChanged();
                return this;
            }

            public Builder clearRegion() {
                this.region_ = Common.getDefaultInstance().getRegion();
                onChanged();
                return this;
            }

            public Builder clearRequestId() {
                this.requestId_ = Common.getDefaultInstance().getRequestId();
                onChanged();
                return this;
            }

            public Builder clearScreenHigh() {
                this.screenHigh_ = 0;
                onChanged();
                return this;
            }

            public Builder clearScreenWidth() {
                this.screenWidth_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSdkVersionCode() {
                this.sdkVersionCode_ = 0;
                onChanged();
                return this;
            }

            public Builder clearServerIp() {
                this.serverIp_ = Common.getDefaultInstance().getServerIp();
                onChanged();
                return this;
            }

            public Builder clearSmid() {
                this.smid_ = Common.getDefaultInstance().getSmid();
                onChanged();
                return this;
            }

            public Builder clearTimezone() {
                this.timezone_ = Common.getDefaultInstance().getTimezone();
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.uid_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearUidStr() {
                this.uidStr_ = Common.getDefaultInstance().getUidStr();
                onChanged();
                return this;
            }

            public Builder clearVipType() {
                this.vipType_ = Common.getDefaultInstance().getVipType();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getAaid() {
                Object obj = this.aaid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.aaid_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getAaidBytes() {
                Object obj = this.aaid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.aaid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getAppType() {
                Object obj = this.appType_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.appType_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getAppTypeBytes() {
                Object obj = this.appType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.appType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getAppVersion() {
                Object obj = this.appVersion_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.appVersion_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getAppVersionBytes() {
                Object obj = this.appVersion_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.appVersion_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public int getAppVersionCode() {
                return this.appVersionCode_;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getBoxId() {
                Object obj = this.boxId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.boxId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getBoxIdBytes() {
                Object obj = this.boxId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.boxId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getChannel() {
                Object obj = this.channel_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.channel_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getChannelBytes() {
                Object obj = this.channel_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.channel_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getClientIp() {
                Object obj = this.clientIp_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.clientIp_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getClientIpBytes() {
                Object obj = this.clientIp_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.clientIp_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Common getDefaultInstanceForType() {
                return Common.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CommonProtos.internal_static_com_blued_das_Common_descriptor;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getDevDna() {
                Object obj = this.devDna_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.devDna_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getDevDnaBytes() {
                Object obj = this.devDna_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.devDna_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getDevice() {
                Object obj = this.device_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.device_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getDeviceBytes() {
                Object obj = this.device_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.device_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getIdfa() {
                Object obj = this.idfa_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.idfa_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getIdfaBytes() {
                Object obj = this.idfa_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.idfa_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getIdfv() {
                Object obj = this.idfv_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.idfv_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getIdfvBytes() {
                Object obj = this.idfv_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.idfv_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getImei() {
                Object obj = this.imei_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.imei_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getImeiBytes() {
                Object obj = this.imei_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.imei_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getLanguage() {
                Object obj = this.language_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.language_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getLanguageBytes() {
                Object obj = this.language_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.language_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getLat() {
                Object obj = this.lat_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.lat_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getLatBytes() {
                Object obj = this.lat_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.lat_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getLon() {
                Object obj = this.lon_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.lon_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getLonBytes() {
                Object obj = this.lon_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.lon_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getNet() {
                Object obj = this.net_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.net_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getNetBytes() {
                Object obj = this.net_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.net_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getNetOp() {
                Object obj = this.netOp_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.netOp_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getNetOpBytes() {
                Object obj = this.netOp_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.netOp_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getOaid() {
                Object obj = this.oaid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.oaid_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getOaidBytes() {
                Object obj = this.oaid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.oaid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getOsVersion() {
                Object obj = this.osVersion_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.osVersion_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getOsVersionBytes() {
                Object obj = this.osVersion_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.osVersion_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getPlatform() {
                Object obj = this.platform_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.platform_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getPlatformBytes() {
                Object obj = this.platform_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.platform_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getRegion() {
                Object obj = this.region_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.region_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getRegionBytes() {
                Object obj = this.region_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.region_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getRequestId() {
                Object obj = this.requestId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.requestId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getRequestIdBytes() {
                Object obj = this.requestId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.requestId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public int getScreenHigh() {
                return this.screenHigh_;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public int getScreenWidth() {
                return this.screenWidth_;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public int getSdkVersionCode() {
                return this.sdkVersionCode_;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getServerIp() {
                Object obj = this.serverIp_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.serverIp_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getServerIpBytes() {
                Object obj = this.serverIp_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.serverIp_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getSmid() {
                Object obj = this.smid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.smid_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getSmidBytes() {
                Object obj = this.smid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.smid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getTimezone() {
                Object obj = this.timezone_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.timezone_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getTimezoneBytes() {
                Object obj = this.timezone_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.timezone_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public long getUid() {
                return this.uid_;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getUidStr() {
                Object obj = this.uidStr_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.uidStr_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getUidStrBytes() {
                Object obj = this.uidStr_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.uidStr_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public String getVipType() {
                Object obj = this.vipType_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.vipType_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.CommonProtos.CommonOrBuilder
            public ByteString getVipTypeBytes() {
                Object obj = this.vipType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.vipType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CommonProtos.internal_static_com_blued_das_Common_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Common common) {
                if (common == Common.getDefaultInstance()) {
                    return this;
                }
                if (!common.getNetOp().isEmpty()) {
                    this.netOp_ = common.netOp_;
                    onChanged();
                }
                if (!common.getNet().isEmpty()) {
                    this.net_ = common.net_;
                    onChanged();
                }
                if (!common.getLat().isEmpty()) {
                    this.lat_ = common.lat_;
                    onChanged();
                }
                if (!common.getLon().isEmpty()) {
                    this.lon_ = common.lon_;
                    onChanged();
                }
                if (!common.getChannel().isEmpty()) {
                    this.channel_ = common.channel_;
                    onChanged();
                }
                if (common.getUid() != 0) {
                    setUid(common.getUid());
                }
                if (!common.getPlatform().isEmpty()) {
                    this.platform_ = common.platform_;
                    onChanged();
                }
                if (!common.getAppVersion().isEmpty()) {
                    this.appVersion_ = common.appVersion_;
                    onChanged();
                }
                if (common.getScreenWidth() != 0) {
                    setScreenWidth(common.getScreenWidth());
                }
                if (common.getScreenHigh() != 0) {
                    setScreenHigh(common.getScreenHigh());
                }
                if (!common.getOsVersion().isEmpty()) {
                    this.osVersion_ = common.osVersion_;
                    onChanged();
                }
                if (!common.getDevice().isEmpty()) {
                    this.device_ = common.device_;
                    onChanged();
                }
                if (!common.getClientIp().isEmpty()) {
                    this.clientIp_ = common.clientIp_;
                    onChanged();
                }
                if (!common.getImei().isEmpty()) {
                    this.imei_ = common.imei_;
                    onChanged();
                }
                if (!common.getIdfa().isEmpty()) {
                    this.idfa_ = common.idfa_;
                    onChanged();
                }
                if (!common.getSmid().isEmpty()) {
                    this.smid_ = common.smid_;
                    onChanged();
                }
                if (!common.getDevDna().isEmpty()) {
                    this.devDna_ = common.devDna_;
                    onChanged();
                }
                if (!common.getTimezone().isEmpty()) {
                    this.timezone_ = common.timezone_;
                    onChanged();
                }
                if (!common.getRequestId().isEmpty()) {
                    this.requestId_ = common.requestId_;
                    onChanged();
                }
                if (!common.getServerIp().isEmpty()) {
                    this.serverIp_ = common.serverIp_;
                    onChanged();
                }
                if (!common.getUidStr().isEmpty()) {
                    this.uidStr_ = common.uidStr_;
                    onChanged();
                }
                if (!common.getLanguage().isEmpty()) {
                    this.language_ = common.language_;
                    onChanged();
                }
                if (!common.getRegion().isEmpty()) {
                    this.region_ = common.region_;
                    onChanged();
                }
                if (!common.getIdfv().isEmpty()) {
                    this.idfv_ = common.idfv_;
                    onChanged();
                }
                if (!common.getVipType().isEmpty()) {
                    this.vipType_ = common.vipType_;
                    onChanged();
                }
                if (common.getAppVersionCode() != 0) {
                    setAppVersionCode(common.getAppVersionCode());
                }
                if (!common.getAppType().isEmpty()) {
                    this.appType_ = common.appType_;
                    onChanged();
                }
                if (!common.getBoxId().isEmpty()) {
                    this.boxId_ = common.boxId_;
                    onChanged();
                }
                if (common.getSdkVersionCode() != 0) {
                    setSdkVersionCode(common.getSdkVersionCode());
                }
                if (!common.getAaid().isEmpty()) {
                    this.aaid_ = common.aaid_;
                    onChanged();
                }
                if (!common.getOaid().isEmpty()) {
                    this.oaid_ = common.oaid_;
                    onChanged();
                }
                mergeUnknownFields(common.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.CommonProtos.Common.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.CommonProtos.Common.access$3800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.CommonProtos$Common r0 = (com.blued.das.CommonProtos.Common) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.CommonProtos$Common$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.CommonProtos$Common r0 = (com.blued.das.CommonProtos.Common) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.CommonProtos$Common$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.CommonProtos.Common.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.CommonProtos$Common$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Common) {
                    return mergeFrom((Common) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setAaid(String str) {
                if (str != null) {
                    this.aaid_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAaidBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.aaid_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAppType(String str) {
                if (str != null) {
                    this.appType_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAppTypeBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.appType_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAppVersion(String str) {
                if (str != null) {
                    this.appVersion_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAppVersionBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.appVersion_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAppVersionCode(int i) {
                this.appVersionCode_ = i;
                onChanged();
                return this;
            }

            public Builder setBoxId(String str) {
                if (str != null) {
                    this.boxId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setBoxIdBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.boxId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setChannel(String str) {
                if (str != null) {
                    this.channel_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setChannelBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.channel_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setClientIp(String str) {
                if (str != null) {
                    this.clientIp_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setClientIpBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.clientIp_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDevDna(String str) {
                if (str != null) {
                    this.devDna_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDevDnaBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.devDna_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDevice(String str) {
                if (str != null) {
                    this.device_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDeviceBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.device_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setIdfa(String str) {
                if (str != null) {
                    this.idfa_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setIdfaBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.idfa_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setIdfv(String str) {
                if (str != null) {
                    this.idfv_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setIdfvBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.idfv_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setImei(String str) {
                if (str != null) {
                    this.imei_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setImeiBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.imei_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLanguage(String str) {
                if (str != null) {
                    this.language_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLanguageBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.language_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLat(String str) {
                if (str != null) {
                    this.lat_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLatBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.lat_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLon(String str) {
                if (str != null) {
                    this.lon_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLonBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.lon_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setNet(String str) {
                if (str != null) {
                    this.net_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setNetBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.net_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setNetOp(String str) {
                if (str != null) {
                    this.netOp_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setNetOpBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.netOp_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setOaid(String str) {
                if (str != null) {
                    this.oaid_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setOaidBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.oaid_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setOsVersion(String str) {
                if (str != null) {
                    this.osVersion_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setOsVersionBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.osVersion_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPlatform(String str) {
                if (str != null) {
                    this.platform_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPlatformBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.platform_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRegion(String str) {
                if (str != null) {
                    this.region_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRegionBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.region_ = byteString;
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
                    Common.checkByteStringIsUtf8(byteString);
                    this.requestId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setScreenHigh(int i) {
                this.screenHigh_ = i;
                onChanged();
                return this;
            }

            public Builder setScreenWidth(int i) {
                this.screenWidth_ = i;
                onChanged();
                return this;
            }

            public Builder setSdkVersionCode(int i) {
                this.sdkVersionCode_ = i;
                onChanged();
                return this;
            }

            public Builder setServerIp(String str) {
                if (str != null) {
                    this.serverIp_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setServerIpBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.serverIp_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setSmid(String str) {
                if (str != null) {
                    this.smid_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setSmidBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.smid_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTimezone(String str) {
                if (str != null) {
                    this.timezone_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTimezoneBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.timezone_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setUid(long j) {
                this.uid_ = j;
                onChanged();
                return this;
            }

            public Builder setUidStr(String str) {
                if (str != null) {
                    this.uidStr_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setUidStrBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.uidStr_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public Builder setVipType(String str) {
                if (str != null) {
                    this.vipType_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setVipTypeBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.vipType_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }
        }

        private Common() {
            this.memoizedIsInitialized = (byte) -1;
            this.netOp_ = "";
            this.net_ = "";
            this.lat_ = "";
            this.lon_ = "";
            this.channel_ = "";
            this.platform_ = "";
            this.appVersion_ = "";
            this.osVersion_ = "";
            this.device_ = "";
            this.clientIp_ = "";
            this.imei_ = "";
            this.idfa_ = "";
            this.smid_ = "";
            this.devDna_ = "";
            this.timezone_ = "";
            this.requestId_ = "";
            this.serverIp_ = "";
            this.uidStr_ = "";
            this.language_ = "";
            this.region_ = "";
            this.idfv_ = "";
            this.vipType_ = "";
            this.appType_ = "";
            this.boxId_ = "";
            this.aaid_ = "";
            this.oaid_ = "";
        }

        private Common(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        switch (readTag) {
                            case 0:
                                break;
                            case 10:
                                this.netOp_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 18:
                                this.net_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 26:
                                this.lat_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 34:
                                this.lon_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 42:
                                this.channel_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 48:
                                this.uid_ = codedInputStream.readInt64();
                                continue;
                            case 58:
                                this.platform_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 66:
                                this.appVersion_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 72:
                                this.screenWidth_ = codedInputStream.readInt32();
                                continue;
                            case 80:
                                this.screenHigh_ = codedInputStream.readInt32();
                                continue;
                            case 90:
                                this.osVersion_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 98:
                                this.device_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 106:
                                this.clientIp_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 114:
                                this.imei_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 122:
                                this.idfa_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 130:
                                this.smid_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 138:
                                this.devDna_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 146:
                                this.timezone_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 154:
                                this.requestId_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 162:
                                this.serverIp_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 170:
                                this.uidStr_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 178:
                                this.language_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 186:
                                this.region_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 194:
                                this.idfv_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 202:
                                this.vipType_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 208:
                                this.appVersionCode_ = codedInputStream.readInt32();
                                continue;
                            case 218:
                                this.appType_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 226:
                                this.boxId_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 232:
                                this.sdkVersionCode_ = codedInputStream.readInt32();
                                continue;
                            case 242:
                                this.aaid_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 250:
                                this.oaid_ = codedInputStream.readStringRequireUtf8();
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
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        private Common(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Common getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CommonProtos.internal_static_com_blued_das_Common_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Common common) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(common);
        }

        public static Common parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Common) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Common parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Common) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Common parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Common parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Common parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Common) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Common parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Common) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Common parseFrom(InputStream inputStream) throws IOException {
            return (Common) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Common parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Common) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Common parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Common parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Common parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Common parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Common> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Common) {
                Common common = (Common) obj;
                return getNetOp().equals(common.getNetOp()) && getNet().equals(common.getNet()) && getLat().equals(common.getLat()) && getLon().equals(common.getLon()) && getChannel().equals(common.getChannel()) && getUid() == common.getUid() && getPlatform().equals(common.getPlatform()) && getAppVersion().equals(common.getAppVersion()) && getScreenWidth() == common.getScreenWidth() && getScreenHigh() == common.getScreenHigh() && getOsVersion().equals(common.getOsVersion()) && getDevice().equals(common.getDevice()) && getClientIp().equals(common.getClientIp()) && getImei().equals(common.getImei()) && getIdfa().equals(common.getIdfa()) && getSmid().equals(common.getSmid()) && getDevDna().equals(common.getDevDna()) && getTimezone().equals(common.getTimezone()) && getRequestId().equals(common.getRequestId()) && getServerIp().equals(common.getServerIp()) && getUidStr().equals(common.getUidStr()) && getLanguage().equals(common.getLanguage()) && getRegion().equals(common.getRegion()) && getIdfv().equals(common.getIdfv()) && getVipType().equals(common.getVipType()) && getAppVersionCode() == common.getAppVersionCode() && getAppType().equals(common.getAppType()) && getBoxId().equals(common.getBoxId()) && getSdkVersionCode() == common.getSdkVersionCode() && getAaid().equals(common.getAaid()) && getOaid().equals(common.getOaid()) && this.unknownFields.equals(common.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getAaid() {
            Object obj = this.aaid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.aaid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getAaidBytes() {
            Object obj = this.aaid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.aaid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getAppType() {
            Object obj = this.appType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.appType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getAppTypeBytes() {
            Object obj = this.appType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.appType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getAppVersion() {
            Object obj = this.appVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.appVersion_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getAppVersionBytes() {
            Object obj = this.appVersion_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.appVersion_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public int getAppVersionCode() {
            return this.appVersionCode_;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getBoxId() {
            Object obj = this.boxId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.boxId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getBoxIdBytes() {
            Object obj = this.boxId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.boxId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getChannel() {
            Object obj = this.channel_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.channel_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getChannelBytes() {
            Object obj = this.channel_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.channel_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getClientIp() {
            Object obj = this.clientIp_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.clientIp_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getClientIpBytes() {
            Object obj = this.clientIp_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.clientIp_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Common getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getDevDna() {
            Object obj = this.devDna_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.devDna_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getDevDnaBytes() {
            Object obj = this.devDna_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.devDna_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getDevice() {
            Object obj = this.device_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.device_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getDeviceBytes() {
            Object obj = this.device_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.device_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getIdfa() {
            Object obj = this.idfa_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.idfa_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getIdfaBytes() {
            Object obj = this.idfa_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.idfa_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getIdfv() {
            Object obj = this.idfv_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.idfv_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getIdfvBytes() {
            Object obj = this.idfv_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.idfv_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getImei() {
            Object obj = this.imei_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.imei_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getImeiBytes() {
            Object obj = this.imei_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.imei_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getLanguage() {
            Object obj = this.language_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.language_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getLanguageBytes() {
            Object obj = this.language_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.language_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getLat() {
            Object obj = this.lat_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.lat_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getLatBytes() {
            Object obj = this.lat_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.lat_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getLon() {
            Object obj = this.lon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.lon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getLonBytes() {
            Object obj = this.lon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.lon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getNet() {
            Object obj = this.net_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.net_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getNetBytes() {
            Object obj = this.net_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.net_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getNetOp() {
            Object obj = this.netOp_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.netOp_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getNetOpBytes() {
            Object obj = this.netOp_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.netOp_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getOaid() {
            Object obj = this.oaid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.oaid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getOaidBytes() {
            Object obj = this.oaid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.oaid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getOsVersion() {
            Object obj = this.osVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.osVersion_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getOsVersionBytes() {
            Object obj = this.osVersion_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.osVersion_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Common> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getPlatform() {
            Object obj = this.platform_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.platform_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getPlatformBytes() {
            Object obj = this.platform_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.platform_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getRegion() {
            Object obj = this.region_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.region_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getRegionBytes() {
            Object obj = this.region_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.region_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getRequestId() {
            Object obj = this.requestId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.requestId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getRequestIdBytes() {
            Object obj = this.requestId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.requestId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public int getScreenHigh() {
            return this.screenHigh_;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public int getScreenWidth() {
            return this.screenWidth_;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public int getSdkVersionCode() {
            return this.sdkVersionCode_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getNetOpBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.netOp_);
            }
            int i3 = i2;
            if (!getNetBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.net_);
            }
            int i4 = i3;
            if (!getLatBytes().isEmpty()) {
                i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.lat_);
            }
            int i5 = i4;
            if (!getLonBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(4, this.lon_);
            }
            int i6 = i5;
            if (!getChannelBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(5, this.channel_);
            }
            long j = this.uid_;
            int i7 = i6;
            if (j != 0) {
                i7 = i6 + CodedOutputStream.computeInt64Size(6, j);
            }
            int i8 = i7;
            if (!getPlatformBytes().isEmpty()) {
                i8 = i7 + GeneratedMessageV3.computeStringSize(7, this.platform_);
            }
            int i9 = i8;
            if (!getAppVersionBytes().isEmpty()) {
                i9 = i8 + GeneratedMessageV3.computeStringSize(8, this.appVersion_);
            }
            int i10 = this.screenWidth_;
            int i11 = i9;
            if (i10 != 0) {
                i11 = i9 + CodedOutputStream.computeInt32Size(9, i10);
            }
            int i12 = this.screenHigh_;
            int i13 = i11;
            if (i12 != 0) {
                i13 = i11 + CodedOutputStream.computeInt32Size(10, i12);
            }
            int i14 = i13;
            if (!getOsVersionBytes().isEmpty()) {
                i14 = i13 + GeneratedMessageV3.computeStringSize(11, this.osVersion_);
            }
            int i15 = i14;
            if (!getDeviceBytes().isEmpty()) {
                i15 = i14 + GeneratedMessageV3.computeStringSize(12, this.device_);
            }
            int i16 = i15;
            if (!getClientIpBytes().isEmpty()) {
                i16 = i15 + GeneratedMessageV3.computeStringSize(13, this.clientIp_);
            }
            int i17 = i16;
            if (!getImeiBytes().isEmpty()) {
                i17 = i16 + GeneratedMessageV3.computeStringSize(14, this.imei_);
            }
            int i18 = i17;
            if (!getIdfaBytes().isEmpty()) {
                i18 = i17 + GeneratedMessageV3.computeStringSize(15, this.idfa_);
            }
            int i19 = i18;
            if (!getSmidBytes().isEmpty()) {
                i19 = i18 + GeneratedMessageV3.computeStringSize(16, this.smid_);
            }
            int i20 = i19;
            if (!getDevDnaBytes().isEmpty()) {
                i20 = i19 + GeneratedMessageV3.computeStringSize(17, this.devDna_);
            }
            int i21 = i20;
            if (!getTimezoneBytes().isEmpty()) {
                i21 = i20 + GeneratedMessageV3.computeStringSize(18, this.timezone_);
            }
            int i22 = i21;
            if (!getRequestIdBytes().isEmpty()) {
                i22 = i21 + GeneratedMessageV3.computeStringSize(19, this.requestId_);
            }
            int i23 = i22;
            if (!getServerIpBytes().isEmpty()) {
                i23 = i22 + GeneratedMessageV3.computeStringSize(20, this.serverIp_);
            }
            int i24 = i23;
            if (!getUidStrBytes().isEmpty()) {
                i24 = i23 + GeneratedMessageV3.computeStringSize(21, this.uidStr_);
            }
            int i25 = i24;
            if (!getLanguageBytes().isEmpty()) {
                i25 = i24 + GeneratedMessageV3.computeStringSize(22, this.language_);
            }
            int i26 = i25;
            if (!getRegionBytes().isEmpty()) {
                i26 = i25 + GeneratedMessageV3.computeStringSize(23, this.region_);
            }
            int i27 = i26;
            if (!getIdfvBytes().isEmpty()) {
                i27 = i26 + GeneratedMessageV3.computeStringSize(24, this.idfv_);
            }
            int i28 = i27;
            if (!getVipTypeBytes().isEmpty()) {
                i28 = i27 + GeneratedMessageV3.computeStringSize(25, this.vipType_);
            }
            int i29 = this.appVersionCode_;
            int i30 = i28;
            if (i29 != 0) {
                i30 = i28 + CodedOutputStream.computeInt32Size(26, i29);
            }
            int i31 = i30;
            if (!getAppTypeBytes().isEmpty()) {
                i31 = i30 + GeneratedMessageV3.computeStringSize(27, this.appType_);
            }
            int i32 = i31;
            if (!getBoxIdBytes().isEmpty()) {
                i32 = i31 + GeneratedMessageV3.computeStringSize(28, this.boxId_);
            }
            int i33 = this.sdkVersionCode_;
            int i34 = i32;
            if (i33 != 0) {
                i34 = i32 + CodedOutputStream.computeInt32Size(29, i33);
            }
            int i35 = i34;
            if (!getAaidBytes().isEmpty()) {
                i35 = i34 + GeneratedMessageV3.computeStringSize(30, this.aaid_);
            }
            int i36 = i35;
            if (!getOaidBytes().isEmpty()) {
                i36 = i35 + GeneratedMessageV3.computeStringSize(31, this.oaid_);
            }
            int serializedSize = i36 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getServerIp() {
            Object obj = this.serverIp_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.serverIp_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getServerIpBytes() {
            Object obj = this.serverIp_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.serverIp_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getSmid() {
            Object obj = this.smid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.smid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getSmidBytes() {
            Object obj = this.smid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.smid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getTimezone() {
            Object obj = this.timezone_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.timezone_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getTimezoneBytes() {
            Object obj = this.timezone_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.timezone_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public long getUid() {
            return this.uid_;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getUidStr() {
            Object obj = this.uidStr_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.uidStr_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getUidStrBytes() {
            Object obj = this.uidStr_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.uidStr_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public String getVipType() {
            Object obj = this.vipType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.vipType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.CommonProtos.CommonOrBuilder
        public ByteString getVipTypeBytes() {
            Object obj = this.vipType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.vipType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getNetOp().hashCode()) * 37) + 2) * 53) + getNet().hashCode()) * 37) + 3) * 53) + getLat().hashCode()) * 37) + 4) * 53) + getLon().hashCode()) * 37) + 5) * 53) + getChannel().hashCode()) * 37) + 6) * 53) + Internal.hashLong(getUid())) * 37) + 7) * 53) + getPlatform().hashCode()) * 37) + 8) * 53) + getAppVersion().hashCode()) * 37) + 9) * 53) + getScreenWidth()) * 37) + 10) * 53) + getScreenHigh()) * 37) + 11) * 53) + getOsVersion().hashCode()) * 37) + 12) * 53) + getDevice().hashCode()) * 37) + 13) * 53) + getClientIp().hashCode()) * 37) + 14) * 53) + getImei().hashCode()) * 37) + 15) * 53) + getIdfa().hashCode()) * 37) + 16) * 53) + getSmid().hashCode()) * 37) + 17) * 53) + getDevDna().hashCode()) * 37) + 18) * 53) + getTimezone().hashCode()) * 37) + 19) * 53) + getRequestId().hashCode()) * 37) + 20) * 53) + getServerIp().hashCode()) * 37) + 21) * 53) + getUidStr().hashCode()) * 37) + 22) * 53) + getLanguage().hashCode()) * 37) + 23) * 53) + getRegion().hashCode()) * 37) + 24) * 53) + getIdfv().hashCode()) * 37) + 25) * 53) + getVipType().hashCode()) * 37) + 26) * 53) + getAppVersionCode()) * 37) + 27) * 53) + getAppType().hashCode()) * 37) + 28) * 53) + getBoxId().hashCode()) * 37) + 29) * 53) + getSdkVersionCode()) * 37) + 30) * 53) + getAaid().hashCode()) * 37) + 31) * 53) + getOaid().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CommonProtos.internal_static_com_blued_das_Common_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.class, Builder.class);
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
            return new Common();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getNetOpBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.netOp_);
            }
            if (!getNetBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.net_);
            }
            if (!getLatBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.lat_);
            }
            if (!getLonBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.lon_);
            }
            if (!getChannelBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.channel_);
            }
            long j = this.uid_;
            if (j != 0) {
                codedOutputStream.writeInt64(6, j);
            }
            if (!getPlatformBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.platform_);
            }
            if (!getAppVersionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.appVersion_);
            }
            int i = this.screenWidth_;
            if (i != 0) {
                codedOutputStream.writeInt32(9, i);
            }
            int i2 = this.screenHigh_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(10, i2);
            }
            if (!getOsVersionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 11, this.osVersion_);
            }
            if (!getDeviceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 12, this.device_);
            }
            if (!getClientIpBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 13, this.clientIp_);
            }
            if (!getImeiBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 14, this.imei_);
            }
            if (!getIdfaBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 15, this.idfa_);
            }
            if (!getSmidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 16, this.smid_);
            }
            if (!getDevDnaBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 17, this.devDna_);
            }
            if (!getTimezoneBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 18, this.timezone_);
            }
            if (!getRequestIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 19, this.requestId_);
            }
            if (!getServerIpBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 20, this.serverIp_);
            }
            if (!getUidStrBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 21, this.uidStr_);
            }
            if (!getLanguageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 22, this.language_);
            }
            if (!getRegionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 23, this.region_);
            }
            if (!getIdfvBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 24, this.idfv_);
            }
            if (!getVipTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 25, this.vipType_);
            }
            int i3 = this.appVersionCode_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(26, i3);
            }
            if (!getAppTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 27, this.appType_);
            }
            if (!getBoxIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 28, this.boxId_);
            }
            int i4 = this.sdkVersionCode_;
            if (i4 != 0) {
                codedOutputStream.writeInt32(29, i4);
            }
            if (!getAaidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 30, this.aaid_);
            }
            if (!getOaidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 31, this.oaid_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/CommonProtos$CommonOrBuilder.class */
    public interface CommonOrBuilder extends MessageOrBuilder {
        String getAaid();

        ByteString getAaidBytes();

        String getAppType();

        ByteString getAppTypeBytes();

        String getAppVersion();

        ByteString getAppVersionBytes();

        int getAppVersionCode();

        String getBoxId();

        ByteString getBoxIdBytes();

        String getChannel();

        ByteString getChannelBytes();

        String getClientIp();

        ByteString getClientIpBytes();

        String getDevDna();

        ByteString getDevDnaBytes();

        String getDevice();

        ByteString getDeviceBytes();

        String getIdfa();

        ByteString getIdfaBytes();

        String getIdfv();

        ByteString getIdfvBytes();

        String getImei();

        ByteString getImeiBytes();

        String getLanguage();

        ByteString getLanguageBytes();

        String getLat();

        ByteString getLatBytes();

        String getLon();

        ByteString getLonBytes();

        String getNet();

        ByteString getNetBytes();

        String getNetOp();

        ByteString getNetOpBytes();

        String getOaid();

        ByteString getOaidBytes();

        String getOsVersion();

        ByteString getOsVersionBytes();

        String getPlatform();

        ByteString getPlatformBytes();

        String getRegion();

        ByteString getRegionBytes();

        String getRequestId();

        ByteString getRequestIdBytes();

        int getScreenHigh();

        int getScreenWidth();

        int getSdkVersionCode();

        String getServerIp();

        ByteString getServerIpBytes();

        String getSmid();

        ByteString getSmidBytes();

        String getTimezone();

        ByteString getTimezoneBytes();

        long getUid();

        String getUidStr();

        ByteString getUidStrBytes();

        String getVipType();

        ByteString getVipTypeBytes();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_das_Common_descriptor = descriptor2;
        internal_static_com_blued_das_Common_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"NetOp", "Net", "Lat", "Lon", "Channel", "Uid", "Platform", "AppVersion", "ScreenWidth", "ScreenHigh", "OsVersion", "Device", "ClientIp", "Imei", "Idfa", "Smid", "DevDna", "Timezone", "RequestId", "ServerIp", "UidStr", "Language", "Region", "Idfv", "VipType", "AppVersionCode", "AppType", "BoxId", "SdkVersionCode", "Aaid", "Oaid"});
    }

    private CommonProtos() {
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
