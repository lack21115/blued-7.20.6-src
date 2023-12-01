package com.blued.im.req;

import com.blued.im.CommonOuterClass;
import com.blued.im.req.ReqCode;
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

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqOuterClass.class */
public final class ReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\tReq.proto\u0012\u0010com.blued.im.req\u001a\rReqCode.proto\u001a\fCommon.proto\"G\n\u000bRequestBody\u0012\u0012\n\nsession_id\u0018\u0001 \u0001(\r\u0012\u0014\n\fsession_type\u0018\u0002 \u0001(\r\u0012\u000e\n\u0006msg_id\u0018\u0003 \u0001(\u0004\"\u0091\u0001\n\u0007Request\u0012$\n\u0006common\u0018\u0001 \u0001(\u000b2\u0014.com.blued.im.Common\u0012\u000f\n\u0007user_id\u0018\u0002 \u0001(\r\u0012\u0010\n\blocal_id\u0018\u0003 \u0001(\r\u0012\u0010\n\breq_type\u0018\u0004 \u0001(\r\u0012+\n\u0004body\u0018\u0005 \u0001(\u000b2\u001d.com.blued.im.req.RequestBody\"A\n\bResponse\u0012$\n\u0004code\u0018\u0001 \u0001(\u000e2\u0016.com.blued.im.req.Code\u0012\u000f\n\u0007message\u0018\u0002 \u0001(\t\"Ê\u0002\n\u0013SessionInfoResponse\u0012$\n\u0004code\u0018\u0001 \u0001(\u000e2\u0016.com.blued.im.req.Code\u0012\u000f\n\u0007message\u0018\u0002 \u0001(\t\u0012\f\n\u0004name\u0018\u0003 \u0001(\t\u0012\u0013\n\u000bdescription\u0018\u0004 \u0001(\t\u0012\u000e\n\u0006avatar\u0018\u0005 \u0001(\t\u0012\f\n\u0004note\u0018\u0006 \u0001(\t\u0012\u000e\n\u0006vbadge\u0018\u0007 \u0001(\u0003\u0012\u0012\n\nvip_annual\u0018\b \u0001(\u0003\u0012\u0011\n\tVip_grade\u0018\t \u0001(\u0003\u0012\u0013\n\u000bvip_exp_lvl\u0018\n \u0001(\u0003\u0012\u0018\n\u0010is_hide_vip_look\u0018\u000b \u0001(\b\u0012\u0013\n\u000bo_vip_grade\u0018\f \u0001(\u0003\u0012\u001a\n\u0012o_is_hide_vip_look\u0018\r \u0001(\b\u0012\r\n\u0005error\u0018\u000e \u0001(\u0003\u0012\u0015\n\ro_face_status\u0018\u000f \u0001(\u00032¢\u0001\n\u0003Req\u0012T\n\u000eGetSessionInfo\u0012\u0019.com.blued.im.req.Request\u001a%.com.blued.im.req.SessionInfoResponse\"��\u0012E\n\nDelBurnMsg\u0012\u0019.com.blued.im.req.Request\u001a\u001a.com.blued.im.req.Response\"��B\u0006¢\u0002\u0003Reqb\u0006proto3"}, new Descriptors.FileDescriptor[]{ReqCode.getDescriptor(), CommonOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_com_blued_im_req_RequestBody_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_req_RequestBody_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_im_req_Request_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_req_Request_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_im_req_Response_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_req_Response_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_im_req_SessionInfoResponse_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_req_SessionInfoResponse_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqOuterClass$Request.class */
    public static final class Request extends GeneratedMessageV3 implements RequestOrBuilder {
        public static final int BODY_FIELD_NUMBER = 5;
        public static final int COMMON_FIELD_NUMBER = 1;
        public static final int LOCAL_ID_FIELD_NUMBER = 3;
        public static final int REQ_TYPE_FIELD_NUMBER = 4;
        public static final int USER_ID_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private RequestBody body_;
        private CommonOuterClass.Common common_;
        private int localId_;
        private byte memoizedIsInitialized;
        private int reqType_;
        private int userId_;
        private static final Request DEFAULT_INSTANCE = new Request();
        private static final Parser<Request> PARSER = new AbstractParser<Request>() { // from class: com.blued.im.req.ReqOuterClass.Request.1
            @Override // com.google.protobuf.Parser
            public Request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Request(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqOuterClass$Request$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RequestOrBuilder {
            private SingleFieldBuilderV3<RequestBody, RequestBody.Builder, RequestBodyOrBuilder> bodyBuilder_;
            private RequestBody body_;
            private SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> commonBuilder_;
            private CommonOuterClass.Common common_;
            private int localId_;
            private int reqType_;
            private int userId_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private SingleFieldBuilderV3<RequestBody, RequestBody.Builder, RequestBodyOrBuilder> getBodyFieldBuilder() {
                if (this.bodyBuilder_ == null) {
                    this.bodyBuilder_ = new SingleFieldBuilderV3<>(getBody(), getParentForChildren(), isClean());
                    this.body_ = null;
                }
                return this.bodyBuilder_;
            }

            private SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> getCommonFieldBuilder() {
                if (this.commonBuilder_ == null) {
                    this.commonBuilder_ = new SingleFieldBuilderV3<>(getCommon(), getParentForChildren(), isClean());
                    this.common_ = null;
                }
                return this.commonBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ReqOuterClass.internal_static_com_blued_im_req_Request_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Request.alwaysUseFieldBuilders;
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
                request.userId_ = this.userId_;
                request.localId_ = this.localId_;
                request.reqType_ = this.reqType_;
                SingleFieldBuilderV3<RequestBody, RequestBody.Builder, RequestBodyOrBuilder> singleFieldBuilderV32 = this.bodyBuilder_;
                if (singleFieldBuilderV32 == null) {
                    request.body_ = this.body_;
                } else {
                    request.body_ = singleFieldBuilderV32.build();
                }
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
                this.userId_ = 0;
                this.localId_ = 0;
                this.reqType_ = 0;
                if (this.bodyBuilder_ == null) {
                    this.body_ = null;
                    return this;
                }
                this.body_ = null;
                this.bodyBuilder_ = null;
                return this;
            }

            public Builder clearBody() {
                if (this.bodyBuilder_ == null) {
                    this.body_ = null;
                    onChanged();
                    return this;
                }
                this.body_ = null;
                this.bodyBuilder_ = null;
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearLocalId() {
                this.localId_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearReqType() {
                this.reqType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearUserId() {
                this.userId_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.blued.im.req.ReqOuterClass.RequestOrBuilder
            public RequestBody getBody() {
                SingleFieldBuilderV3<RequestBody, RequestBody.Builder, RequestBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    RequestBody requestBody = this.body_;
                    RequestBody requestBody2 = requestBody;
                    if (requestBody == null) {
                        requestBody2 = RequestBody.getDefaultInstance();
                    }
                    return requestBody2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public RequestBody.Builder getBodyBuilder() {
                onChanged();
                return getBodyFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.req.ReqOuterClass.RequestOrBuilder
            public RequestBodyOrBuilder getBodyOrBuilder() {
                SingleFieldBuilderV3<RequestBody, RequestBody.Builder, RequestBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                RequestBody requestBody = this.body_;
                RequestBody requestBody2 = requestBody;
                if (requestBody == null) {
                    requestBody2 = RequestBody.getDefaultInstance();
                }
                return requestBody2;
            }

            @Override // com.blued.im.req.ReqOuterClass.RequestOrBuilder
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

            @Override // com.blued.im.req.ReqOuterClass.RequestOrBuilder
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

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Request getDefaultInstanceForType() {
                return Request.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ReqOuterClass.internal_static_com_blued_im_req_Request_descriptor;
            }

            @Override // com.blued.im.req.ReqOuterClass.RequestOrBuilder
            public int getLocalId() {
                return this.localId_;
            }

            @Override // com.blued.im.req.ReqOuterClass.RequestOrBuilder
            public int getReqType() {
                return this.reqType_;
            }

            @Override // com.blued.im.req.ReqOuterClass.RequestOrBuilder
            public int getUserId() {
                return this.userId_;
            }

            @Override // com.blued.im.req.ReqOuterClass.RequestOrBuilder
            public boolean hasBody() {
                return (this.bodyBuilder_ == null && this.body_ == null) ? false : true;
            }

            @Override // com.blued.im.req.ReqOuterClass.RequestOrBuilder
            public boolean hasCommon() {
                return (this.commonBuilder_ == null && this.common_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ReqOuterClass.internal_static_com_blued_im_req_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeBody(RequestBody requestBody) {
                SingleFieldBuilderV3<RequestBody, RequestBody.Builder, RequestBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(requestBody);
                    return this;
                }
                RequestBody requestBody2 = this.body_;
                if (requestBody2 != null) {
                    this.body_ = RequestBody.newBuilder(requestBody2).mergeFrom(requestBody).buildPartial();
                } else {
                    this.body_ = requestBody;
                }
                onChanged();
                return this;
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

            public Builder mergeFrom(Request request) {
                if (request == Request.getDefaultInstance()) {
                    return this;
                }
                if (request.hasCommon()) {
                    mergeCommon(request.getCommon());
                }
                if (request.getUserId() != 0) {
                    setUserId(request.getUserId());
                }
                if (request.getLocalId() != 0) {
                    setLocalId(request.getLocalId());
                }
                if (request.getReqType() != 0) {
                    setReqType(request.getReqType());
                }
                if (request.hasBody()) {
                    mergeBody(request.getBody());
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
            public com.blued.im.req.ReqOuterClass.Request.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.req.ReqOuterClass.Request.access$2400()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.req.ReqOuterClass$Request r0 = (com.blued.im.req.ReqOuterClass.Request) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.req.ReqOuterClass$Request$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.req.ReqOuterClass$Request r0 = (com.blued.im.req.ReqOuterClass.Request) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.req.ReqOuterClass$Request$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.req.ReqOuterClass.Request.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.req.ReqOuterClass$Request$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Request) {
                    return mergeFrom((Request) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setBody(RequestBody.Builder builder) {
                SingleFieldBuilderV3<RequestBody, RequestBody.Builder, RequestBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.body_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setBody(RequestBody requestBody) {
                SingleFieldBuilderV3<RequestBody, RequestBody.Builder, RequestBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(requestBody);
                    return this;
                } else if (requestBody != null) {
                    this.body_ = requestBody;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setLocalId(int i) {
                this.localId_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setReqType(int i) {
                this.reqType_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public Builder setUserId(int i) {
                this.userId_ = i;
                onChanged();
                return this;
            }
        }

        private Request() {
            this.memoizedIsInitialized = (byte) -1;
        }

        private Request(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                CommonOuterClass.Common.Builder builder = this.common_ != null ? this.common_.toBuilder() : null;
                                CommonOuterClass.Common common = (CommonOuterClass.Common) codedInputStream.readMessage(CommonOuterClass.Common.parser(), extensionRegistryLite);
                                this.common_ = common;
                                if (builder != null) {
                                    builder.mergeFrom(common);
                                    this.common_ = builder.buildPartial();
                                }
                            } else if (readTag == 16) {
                                this.userId_ = codedInputStream.readUInt32();
                            } else if (readTag == 24) {
                                this.localId_ = codedInputStream.readUInt32();
                            } else if (readTag == 32) {
                                this.reqType_ = codedInputStream.readUInt32();
                            } else if (readTag == 42) {
                                RequestBody.Builder builder2 = this.body_ != null ? this.body_.toBuilder() : null;
                                RequestBody requestBody = (RequestBody) codedInputStream.readMessage(RequestBody.parser(), extensionRegistryLite);
                                this.body_ = requestBody;
                                if (builder2 != null) {
                                    builder2.mergeFrom(requestBody);
                                    this.body_ = builder2.buildPartial();
                                }
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

        private Request(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ReqOuterClass.internal_static_com_blued_im_req_Request_descriptor;
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
                if ((!hasCommon() || getCommon().equals(request.getCommon())) && getUserId() == request.getUserId() && getLocalId() == request.getLocalId() && getReqType() == request.getReqType() && hasBody() == request.hasBody()) {
                    return (!hasBody() || getBody().equals(request.getBody())) && this.unknownFields.equals(request.unknownFields);
                }
                return false;
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.req.ReqOuterClass.RequestOrBuilder
        public RequestBody getBody() {
            RequestBody requestBody = this.body_;
            RequestBody requestBody2 = requestBody;
            if (requestBody == null) {
                requestBody2 = RequestBody.getDefaultInstance();
            }
            return requestBody2;
        }

        @Override // com.blued.im.req.ReqOuterClass.RequestOrBuilder
        public RequestBodyOrBuilder getBodyOrBuilder() {
            return getBody();
        }

        @Override // com.blued.im.req.ReqOuterClass.RequestOrBuilder
        public CommonOuterClass.Common getCommon() {
            CommonOuterClass.Common common = this.common_;
            CommonOuterClass.Common common2 = common;
            if (common == null) {
                common2 = CommonOuterClass.Common.getDefaultInstance();
            }
            return common2;
        }

        @Override // com.blued.im.req.ReqOuterClass.RequestOrBuilder
        public CommonOuterClass.CommonOrBuilder getCommonOrBuilder() {
            return getCommon();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Request getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.req.ReqOuterClass.RequestOrBuilder
        public int getLocalId() {
            return this.localId_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Request> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.req.ReqOuterClass.RequestOrBuilder
        public int getReqType() {
            return this.reqType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.common_ != null) {
                i2 = 0 + CodedOutputStream.computeMessageSize(1, getCommon());
            }
            int i3 = this.userId_;
            int i4 = i2;
            if (i3 != 0) {
                i4 = i2 + CodedOutputStream.computeUInt32Size(2, i3);
            }
            int i5 = this.localId_;
            int i6 = i4;
            if (i5 != 0) {
                i6 = i4 + CodedOutputStream.computeUInt32Size(3, i5);
            }
            int i7 = this.reqType_;
            int i8 = i6;
            if (i7 != 0) {
                i8 = i6 + CodedOutputStream.computeUInt32Size(4, i7);
            }
            int i9 = i8;
            if (this.body_ != null) {
                i9 = i8 + CodedOutputStream.computeMessageSize(5, getBody());
            }
            int serializedSize = i9 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.im.req.ReqOuterClass.RequestOrBuilder
        public int getUserId() {
            return this.userId_;
        }

        @Override // com.blued.im.req.ReqOuterClass.RequestOrBuilder
        public boolean hasBody() {
            return this.body_ != null;
        }

        @Override // com.blued.im.req.ReqOuterClass.RequestOrBuilder
        public boolean hasCommon() {
            return this.common_ != null;
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
            int userId = (((((((((((i * 37) + 2) * 53) + getUserId()) * 37) + 3) * 53) + getLocalId()) * 37) + 4) * 53) + getReqType();
            int i2 = userId;
            if (hasBody()) {
                i2 = (((userId * 37) + 5) * 53) + getBody().hashCode();
            }
            int hashCode2 = (i2 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ReqOuterClass.internal_static_com_blued_im_req_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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
            if (this.common_ != null) {
                codedOutputStream.writeMessage(1, getCommon());
            }
            int i = this.userId_;
            if (i != 0) {
                codedOutputStream.writeUInt32(2, i);
            }
            int i2 = this.localId_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(3, i2);
            }
            int i3 = this.reqType_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(4, i3);
            }
            if (this.body_ != null) {
                codedOutputStream.writeMessage(5, getBody());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqOuterClass$RequestBody.class */
    public static final class RequestBody extends GeneratedMessageV3 implements RequestBodyOrBuilder {
        public static final int MSG_ID_FIELD_NUMBER = 3;
        public static final int SESSION_ID_FIELD_NUMBER = 1;
        public static final int SESSION_TYPE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private long msgId_;
        private int sessionId_;
        private int sessionType_;
        private static final RequestBody DEFAULT_INSTANCE = new RequestBody();
        private static final Parser<RequestBody> PARSER = new AbstractParser<RequestBody>() { // from class: com.blued.im.req.ReqOuterClass.RequestBody.1
            @Override // com.google.protobuf.Parser
            public RequestBody parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new RequestBody(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqOuterClass$RequestBody$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RequestBodyOrBuilder {
            private long msgId_;
            private int sessionId_;
            private int sessionType_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ReqOuterClass.internal_static_com_blued_im_req_RequestBody_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = RequestBody.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RequestBody build() {
                RequestBody buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RequestBody buildPartial() {
                RequestBody requestBody = new RequestBody(this);
                requestBody.sessionId_ = this.sessionId_;
                requestBody.sessionType_ = this.sessionType_;
                requestBody.msgId_ = this.msgId_;
                onBuilt();
                return requestBody;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.sessionId_ = 0;
                this.sessionType_ = 0;
                this.msgId_ = 0L;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearMsgId() {
                this.msgId_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearSessionId() {
                this.sessionId_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSessionType() {
                this.sessionType_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RequestBody getDefaultInstanceForType() {
                return RequestBody.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ReqOuterClass.internal_static_com_blued_im_req_RequestBody_descriptor;
            }

            @Override // com.blued.im.req.ReqOuterClass.RequestBodyOrBuilder
            public long getMsgId() {
                return this.msgId_;
            }

            @Override // com.blued.im.req.ReqOuterClass.RequestBodyOrBuilder
            public int getSessionId() {
                return this.sessionId_;
            }

            @Override // com.blued.im.req.ReqOuterClass.RequestBodyOrBuilder
            public int getSessionType() {
                return this.sessionType_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ReqOuterClass.internal_static_com_blued_im_req_RequestBody_fieldAccessorTable.ensureFieldAccessorsInitialized(RequestBody.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(RequestBody requestBody) {
                if (requestBody == RequestBody.getDefaultInstance()) {
                    return this;
                }
                if (requestBody.getSessionId() != 0) {
                    setSessionId(requestBody.getSessionId());
                }
                if (requestBody.getSessionType() != 0) {
                    setSessionType(requestBody.getSessionType());
                }
                if (requestBody.getMsgId() != 0) {
                    setMsgId(requestBody.getMsgId());
                }
                mergeUnknownFields(requestBody.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.req.ReqOuterClass.RequestBody.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.req.ReqOuterClass.RequestBody.access$1000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.req.ReqOuterClass$RequestBody r0 = (com.blued.im.req.ReqOuterClass.RequestBody) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.req.ReqOuterClass$RequestBody$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.req.ReqOuterClass$RequestBody r0 = (com.blued.im.req.ReqOuterClass.RequestBody) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.req.ReqOuterClass$RequestBody$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.req.ReqOuterClass.RequestBody.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.req.ReqOuterClass$RequestBody$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof RequestBody) {
                    return mergeFrom((RequestBody) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setMsgId(long j) {
                this.msgId_ = j;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setSessionId(int i) {
                this.sessionId_ = i;
                onChanged();
                return this;
            }

            public Builder setSessionType(int i) {
                this.sessionType_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private RequestBody() {
            this.memoizedIsInitialized = (byte) -1;
        }

        private RequestBody(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.sessionId_ = codedInputStream.readUInt32();
                                } else if (readTag == 16) {
                                    this.sessionType_ = codedInputStream.readUInt32();
                                } else if (readTag == 24) {
                                    this.msgId_ = codedInputStream.readUInt64();
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

        private RequestBody(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static RequestBody getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ReqOuterClass.internal_static_com_blued_im_req_RequestBody_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RequestBody requestBody) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(requestBody);
        }

        public static RequestBody parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RequestBody) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static RequestBody parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RequestBody) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static RequestBody parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static RequestBody parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static RequestBody parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (RequestBody) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static RequestBody parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RequestBody) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static RequestBody parseFrom(InputStream inputStream) throws IOException {
            return (RequestBody) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static RequestBody parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RequestBody) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static RequestBody parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static RequestBody parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static RequestBody parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static RequestBody parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<RequestBody> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof RequestBody) {
                RequestBody requestBody = (RequestBody) obj;
                return getSessionId() == requestBody.getSessionId() && getSessionType() == requestBody.getSessionType() && getMsgId() == requestBody.getMsgId() && this.unknownFields.equals(requestBody.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RequestBody getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.req.ReqOuterClass.RequestBodyOrBuilder
        public long getMsgId() {
            return this.msgId_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RequestBody> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            int i3 = this.sessionId_;
            if (i3 != 0) {
                i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
            }
            int i4 = this.sessionType_;
            int i5 = i2;
            if (i4 != 0) {
                i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
            }
            long j = this.msgId_;
            int i6 = i5;
            if (j != 0) {
                i6 = i5 + CodedOutputStream.computeUInt64Size(3, j);
            }
            int serializedSize = i6 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.im.req.ReqOuterClass.RequestBodyOrBuilder
        public int getSessionId() {
            return this.sessionId_;
        }

        @Override // com.blued.im.req.ReqOuterClass.RequestBodyOrBuilder
        public int getSessionType() {
            return this.sessionType_;
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
            int hashCode = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getSessionId()) * 37) + 2) * 53) + getSessionType()) * 37) + 3) * 53) + Internal.hashLong(getMsgId())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ReqOuterClass.internal_static_com_blued_im_req_RequestBody_fieldAccessorTable.ensureFieldAccessorsInitialized(RequestBody.class, Builder.class);
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
            return new RequestBody();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.sessionId_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            int i2 = this.sessionType_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(2, i2);
            }
            long j = this.msgId_;
            if (j != 0) {
                codedOutputStream.writeUInt64(3, j);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqOuterClass$RequestBodyOrBuilder.class */
    public interface RequestBodyOrBuilder extends MessageOrBuilder {
        long getMsgId();

        int getSessionId();

        int getSessionType();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqOuterClass$RequestOrBuilder.class */
    public interface RequestOrBuilder extends MessageOrBuilder {
        RequestBody getBody();

        RequestBodyOrBuilder getBodyOrBuilder();

        CommonOuterClass.Common getCommon();

        CommonOuterClass.CommonOrBuilder getCommonOrBuilder();

        int getLocalId();

        int getReqType();

        int getUserId();

        boolean hasBody();

        boolean hasCommon();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqOuterClass$Response.class */
    public static final class Response extends GeneratedMessageV3 implements ResponseOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        public static final int MESSAGE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int code_;
        private byte memoizedIsInitialized;
        private volatile Object message_;
        private static final Response DEFAULT_INSTANCE = new Response();
        private static final Parser<Response> PARSER = new AbstractParser<Response>() { // from class: com.blued.im.req.ReqOuterClass.Response.1
            @Override // com.google.protobuf.Parser
            public Response parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Response(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqOuterClass$Response$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResponseOrBuilder {
            private int code_;
            private Object message_;

            private Builder() {
                this.code_ = 0;
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.code_ = 0;
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ReqOuterClass.internal_static_com_blued_im_req_Response_descriptor;
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
                onBuilt();
                return response;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.code_ = 0;
                this.message_ = "";
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.blued.im.req.ReqOuterClass.ResponseOrBuilder
            public ReqCode.Code getCode() {
                ReqCode.Code valueOf = ReqCode.Code.valueOf(this.code_);
                ReqCode.Code code = valueOf;
                if (valueOf == null) {
                    code = ReqCode.Code.UNRECOGNIZED;
                }
                return code;
            }

            @Override // com.blued.im.req.ReqOuterClass.ResponseOrBuilder
            public int getCodeValue() {
                return this.code_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Response getDefaultInstanceForType() {
                return Response.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ReqOuterClass.internal_static_com_blued_im_req_Response_descriptor;
            }

            @Override // com.blued.im.req.ReqOuterClass.ResponseOrBuilder
            public String getMessage() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.message_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.req.ReqOuterClass.ResponseOrBuilder
            public ByteString getMessageBytes() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.message_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ReqOuterClass.internal_static_com_blued_im_req_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
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
            public com.blued.im.req.ReqOuterClass.Response.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.req.ReqOuterClass.Response.access$3500()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.req.ReqOuterClass$Response r0 = (com.blued.im.req.ReqOuterClass.Response) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.req.ReqOuterClass$Response$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.req.ReqOuterClass$Response r0 = (com.blued.im.req.ReqOuterClass.Response) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.req.ReqOuterClass$Response$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.req.ReqOuterClass.Response.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.req.ReqOuterClass$Response$Builder");
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

            public Builder setCode(ReqCode.Code code) {
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private Response() {
            this.memoizedIsInitialized = (byte) -1;
            this.code_ = 0;
            this.message_ = "";
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
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.code_ = codedInputStream.readEnum();
                                } else if (readTag == 18) {
                                    this.message_ = codedInputStream.readStringRequireUtf8();
                                } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
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

        private Response(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Response getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ReqOuterClass.internal_static_com_blued_im_req_Response_descriptor;
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
                return this.code_ == response.code_ && getMessage().equals(response.getMessage()) && this.unknownFields.equals(response.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.req.ReqOuterClass.ResponseOrBuilder
        public ReqCode.Code getCode() {
            ReqCode.Code valueOf = ReqCode.Code.valueOf(this.code_);
            ReqCode.Code code = valueOf;
            if (valueOf == null) {
                code = ReqCode.Code.UNRECOGNIZED;
            }
            return code;
        }

        @Override // com.blued.im.req.ReqOuterClass.ResponseOrBuilder
        public int getCodeValue() {
            return this.code_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Response getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.req.ReqOuterClass.ResponseOrBuilder
        public String getMessage() {
            Object obj = this.message_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.message_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.req.ReqOuterClass.ResponseOrBuilder
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

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.code_ != ReqCode.Code.REQ_SUCCESS.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.code_);
            }
            int i3 = i2;
            if (!getMessageBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.message_);
            }
            int serializedSize = i3 + this.unknownFields.getSerializedSize();
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
            int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.code_) * 37) + 2) * 53) + getMessage().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ReqOuterClass.internal_static_com_blued_im_req_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
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
            if (this.code_ != ReqCode.Code.REQ_SUCCESS.getNumber()) {
                codedOutputStream.writeEnum(1, this.code_);
            }
            if (!getMessageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.message_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqOuterClass$ResponseOrBuilder.class */
    public interface ResponseOrBuilder extends MessageOrBuilder {
        ReqCode.Code getCode();

        int getCodeValue();

        String getMessage();

        ByteString getMessageBytes();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqOuterClass$SessionInfoResponse.class */
    public static final class SessionInfoResponse extends GeneratedMessageV3 implements SessionInfoResponseOrBuilder {
        public static final int AVATAR_FIELD_NUMBER = 5;
        public static final int CODE_FIELD_NUMBER = 1;
        public static final int DESCRIPTION_FIELD_NUMBER = 4;
        public static final int ERROR_FIELD_NUMBER = 14;
        public static final int IS_HIDE_VIP_LOOK_FIELD_NUMBER = 11;
        public static final int MESSAGE_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 3;
        public static final int NOTE_FIELD_NUMBER = 6;
        public static final int O_FACE_STATUS_FIELD_NUMBER = 15;
        public static final int O_IS_HIDE_VIP_LOOK_FIELD_NUMBER = 13;
        public static final int O_VIP_GRADE_FIELD_NUMBER = 12;
        public static final int VBADGE_FIELD_NUMBER = 7;
        public static final int VIP_ANNUAL_FIELD_NUMBER = 8;
        public static final int VIP_EXP_LVL_FIELD_NUMBER = 10;
        public static final int VIP_GRADE_FIELD_NUMBER = 9;
        private static final long serialVersionUID = 0;
        private volatile Object avatar_;
        private int code_;
        private volatile Object description_;
        private long error_;
        private boolean isHideVipLook_;
        private byte memoizedIsInitialized;
        private volatile Object message_;
        private volatile Object name_;
        private volatile Object note_;
        private long oFaceStatus_;
        private boolean oIsHideVipLook_;
        private long oVipGrade_;
        private long vbadge_;
        private long vipAnnual_;
        private long vipExpLvl_;
        private long vipGrade_;
        private static final SessionInfoResponse DEFAULT_INSTANCE = new SessionInfoResponse();
        private static final Parser<SessionInfoResponse> PARSER = new AbstractParser<SessionInfoResponse>() { // from class: com.blued.im.req.ReqOuterClass.SessionInfoResponse.1
            @Override // com.google.protobuf.Parser
            public SessionInfoResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SessionInfoResponse(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqOuterClass$SessionInfoResponse$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SessionInfoResponseOrBuilder {
            private Object avatar_;
            private int code_;
            private Object description_;
            private long error_;
            private boolean isHideVipLook_;
            private Object message_;
            private Object name_;
            private Object note_;
            private long oFaceStatus_;
            private boolean oIsHideVipLook_;
            private long oVipGrade_;
            private long vbadge_;
            private long vipAnnual_;
            private long vipExpLvl_;
            private long vipGrade_;

            private Builder() {
                this.code_ = 0;
                this.message_ = "";
                this.name_ = "";
                this.description_ = "";
                this.avatar_ = "";
                this.note_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.code_ = 0;
                this.message_ = "";
                this.name_ = "";
                this.description_ = "";
                this.avatar_ = "";
                this.note_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ReqOuterClass.internal_static_com_blued_im_req_SessionInfoResponse_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = SessionInfoResponse.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SessionInfoResponse build() {
                SessionInfoResponse buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SessionInfoResponse buildPartial() {
                SessionInfoResponse sessionInfoResponse = new SessionInfoResponse(this);
                sessionInfoResponse.code_ = this.code_;
                sessionInfoResponse.message_ = this.message_;
                sessionInfoResponse.name_ = this.name_;
                sessionInfoResponse.description_ = this.description_;
                sessionInfoResponse.avatar_ = this.avatar_;
                sessionInfoResponse.note_ = this.note_;
                sessionInfoResponse.vbadge_ = this.vbadge_;
                sessionInfoResponse.vipAnnual_ = this.vipAnnual_;
                sessionInfoResponse.vipGrade_ = this.vipGrade_;
                sessionInfoResponse.vipExpLvl_ = this.vipExpLvl_;
                sessionInfoResponse.isHideVipLook_ = this.isHideVipLook_;
                sessionInfoResponse.oVipGrade_ = this.oVipGrade_;
                sessionInfoResponse.oIsHideVipLook_ = this.oIsHideVipLook_;
                sessionInfoResponse.error_ = this.error_;
                sessionInfoResponse.oFaceStatus_ = this.oFaceStatus_;
                onBuilt();
                return sessionInfoResponse;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.code_ = 0;
                this.message_ = "";
                this.name_ = "";
                this.description_ = "";
                this.avatar_ = "";
                this.note_ = "";
                this.vbadge_ = 0L;
                this.vipAnnual_ = 0L;
                this.vipGrade_ = 0L;
                this.vipExpLvl_ = 0L;
                this.isHideVipLook_ = false;
                this.oVipGrade_ = 0L;
                this.oIsHideVipLook_ = false;
                this.error_ = 0L;
                this.oFaceStatus_ = 0L;
                return this;
            }

            public Builder clearAvatar() {
                this.avatar_ = SessionInfoResponse.getDefaultInstance().getAvatar();
                onChanged();
                return this;
            }

            public Builder clearCode() {
                this.code_ = 0;
                onChanged();
                return this;
            }

            public Builder clearDescription() {
                this.description_ = SessionInfoResponse.getDefaultInstance().getDescription();
                onChanged();
                return this;
            }

            public Builder clearError() {
                this.error_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearIsHideVipLook() {
                this.isHideVipLook_ = false;
                onChanged();
                return this;
            }

            public Builder clearMessage() {
                this.message_ = SessionInfoResponse.getDefaultInstance().getMessage();
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = SessionInfoResponse.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder clearNote() {
                this.note_ = SessionInfoResponse.getDefaultInstance().getNote();
                onChanged();
                return this;
            }

            public Builder clearOFaceStatus() {
                this.oFaceStatus_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearOIsHideVipLook() {
                this.oIsHideVipLook_ = false;
                onChanged();
                return this;
            }

            public Builder clearOVipGrade() {
                this.oVipGrade_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearVbadge() {
                this.vbadge_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearVipAnnual() {
                this.vipAnnual_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearVipExpLvl() {
                this.vipExpLvl_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearVipGrade() {
                this.vipGrade_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public String getAvatar() {
                Object obj = this.avatar_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.avatar_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public ByteString getAvatarBytes() {
                Object obj = this.avatar_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.avatar_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public ReqCode.Code getCode() {
                ReqCode.Code valueOf = ReqCode.Code.valueOf(this.code_);
                ReqCode.Code code = valueOf;
                if (valueOf == null) {
                    code = ReqCode.Code.UNRECOGNIZED;
                }
                return code;
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public int getCodeValue() {
                return this.code_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SessionInfoResponse getDefaultInstanceForType() {
                return SessionInfoResponse.getDefaultInstance();
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public String getDescription() {
                Object obj = this.description_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.description_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public ByteString getDescriptionBytes() {
                Object obj = this.description_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.description_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ReqOuterClass.internal_static_com_blued_im_req_SessionInfoResponse_descriptor;
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public long getError() {
                return this.error_;
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public boolean getIsHideVipLook() {
                return this.isHideVipLook_;
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public String getMessage() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.message_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public ByteString getMessageBytes() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.message_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public String getNote() {
                Object obj = this.note_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.note_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public ByteString getNoteBytes() {
                Object obj = this.note_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.note_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public long getOFaceStatus() {
                return this.oFaceStatus_;
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public boolean getOIsHideVipLook() {
                return this.oIsHideVipLook_;
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public long getOVipGrade() {
                return this.oVipGrade_;
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public long getVbadge() {
                return this.vbadge_;
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public long getVipAnnual() {
                return this.vipAnnual_;
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public long getVipExpLvl() {
                return this.vipExpLvl_;
            }

            @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
            public long getVipGrade() {
                return this.vipGrade_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ReqOuterClass.internal_static_com_blued_im_req_SessionInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SessionInfoResponse.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(SessionInfoResponse sessionInfoResponse) {
                if (sessionInfoResponse == SessionInfoResponse.getDefaultInstance()) {
                    return this;
                }
                if (sessionInfoResponse.code_ != 0) {
                    setCodeValue(sessionInfoResponse.getCodeValue());
                }
                if (!sessionInfoResponse.getMessage().isEmpty()) {
                    this.message_ = sessionInfoResponse.message_;
                    onChanged();
                }
                if (!sessionInfoResponse.getName().isEmpty()) {
                    this.name_ = sessionInfoResponse.name_;
                    onChanged();
                }
                if (!sessionInfoResponse.getDescription().isEmpty()) {
                    this.description_ = sessionInfoResponse.description_;
                    onChanged();
                }
                if (!sessionInfoResponse.getAvatar().isEmpty()) {
                    this.avatar_ = sessionInfoResponse.avatar_;
                    onChanged();
                }
                if (!sessionInfoResponse.getNote().isEmpty()) {
                    this.note_ = sessionInfoResponse.note_;
                    onChanged();
                }
                if (sessionInfoResponse.getVbadge() != 0) {
                    setVbadge(sessionInfoResponse.getVbadge());
                }
                if (sessionInfoResponse.getVipAnnual() != 0) {
                    setVipAnnual(sessionInfoResponse.getVipAnnual());
                }
                if (sessionInfoResponse.getVipGrade() != 0) {
                    setVipGrade(sessionInfoResponse.getVipGrade());
                }
                if (sessionInfoResponse.getVipExpLvl() != 0) {
                    setVipExpLvl(sessionInfoResponse.getVipExpLvl());
                }
                if (sessionInfoResponse.getIsHideVipLook()) {
                    setIsHideVipLook(sessionInfoResponse.getIsHideVipLook());
                }
                if (sessionInfoResponse.getOVipGrade() != 0) {
                    setOVipGrade(sessionInfoResponse.getOVipGrade());
                }
                if (sessionInfoResponse.getOIsHideVipLook()) {
                    setOIsHideVipLook(sessionInfoResponse.getOIsHideVipLook());
                }
                if (sessionInfoResponse.getError() != 0) {
                    setError(sessionInfoResponse.getError());
                }
                if (sessionInfoResponse.getOFaceStatus() != 0) {
                    setOFaceStatus(sessionInfoResponse.getOFaceStatus());
                }
                mergeUnknownFields(sessionInfoResponse.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.req.ReqOuterClass.SessionInfoResponse.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.req.ReqOuterClass.SessionInfoResponse.access$6000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.req.ReqOuterClass$SessionInfoResponse r0 = (com.blued.im.req.ReqOuterClass.SessionInfoResponse) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.req.ReqOuterClass$SessionInfoResponse$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.req.ReqOuterClass$SessionInfoResponse r0 = (com.blued.im.req.ReqOuterClass.SessionInfoResponse) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.req.ReqOuterClass$SessionInfoResponse$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.req.ReqOuterClass.SessionInfoResponse.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.req.ReqOuterClass$SessionInfoResponse$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof SessionInfoResponse) {
                    return mergeFrom((SessionInfoResponse) message);
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
                    SessionInfoResponse.checkByteStringIsUtf8(byteString);
                    this.avatar_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setCode(ReqCode.Code code) {
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

            public Builder setDescription(String str) {
                if (str != null) {
                    this.description_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDescriptionBytes(ByteString byteString) {
                if (byteString != null) {
                    SessionInfoResponse.checkByteStringIsUtf8(byteString);
                    this.description_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setError(long j) {
                this.error_ = j;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setIsHideVipLook(boolean z) {
                this.isHideVipLook_ = z;
                onChanged();
                return this;
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
                    SessionInfoResponse.checkByteStringIsUtf8(byteString);
                    this.message_ = byteString;
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
                    SessionInfoResponse.checkByteStringIsUtf8(byteString);
                    this.name_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setNote(String str) {
                if (str != null) {
                    this.note_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setNoteBytes(ByteString byteString) {
                if (byteString != null) {
                    SessionInfoResponse.checkByteStringIsUtf8(byteString);
                    this.note_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setOFaceStatus(long j) {
                this.oFaceStatus_ = j;
                onChanged();
                return this;
            }

            public Builder setOIsHideVipLook(boolean z) {
                this.oIsHideVipLook_ = z;
                onChanged();
                return this;
            }

            public Builder setOVipGrade(long j) {
                this.oVipGrade_ = j;
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

            public Builder setVbadge(long j) {
                this.vbadge_ = j;
                onChanged();
                return this;
            }

            public Builder setVipAnnual(long j) {
                this.vipAnnual_ = j;
                onChanged();
                return this;
            }

            public Builder setVipExpLvl(long j) {
                this.vipExpLvl_ = j;
                onChanged();
                return this;
            }

            public Builder setVipGrade(long j) {
                this.vipGrade_ = j;
                onChanged();
                return this;
            }
        }

        private SessionInfoResponse() {
            this.memoizedIsInitialized = (byte) -1;
            this.code_ = 0;
            this.message_ = "";
            this.name_ = "";
            this.description_ = "";
            this.avatar_ = "";
            this.note_ = "";
        }

        private SessionInfoResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.code_ = codedInputStream.readEnum();
                                continue;
                            case 18:
                                this.message_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 26:
                                this.name_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 34:
                                this.description_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 42:
                                this.avatar_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 50:
                                this.note_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 56:
                                this.vbadge_ = codedInputStream.readInt64();
                                continue;
                            case 64:
                                this.vipAnnual_ = codedInputStream.readInt64();
                                continue;
                            case 72:
                                this.vipGrade_ = codedInputStream.readInt64();
                                continue;
                            case 80:
                                this.vipExpLvl_ = codedInputStream.readInt64();
                                continue;
                            case 88:
                                this.isHideVipLook_ = codedInputStream.readBool();
                                continue;
                            case 96:
                                this.oVipGrade_ = codedInputStream.readInt64();
                                continue;
                            case 104:
                                this.oIsHideVipLook_ = codedInputStream.readBool();
                                continue;
                            case 112:
                                this.error_ = codedInputStream.readInt64();
                                continue;
                            case 120:
                                this.oFaceStatus_ = codedInputStream.readInt64();
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

        private SessionInfoResponse(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SessionInfoResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ReqOuterClass.internal_static_com_blued_im_req_SessionInfoResponse_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SessionInfoResponse sessionInfoResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(sessionInfoResponse);
        }

        public static SessionInfoResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SessionInfoResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SessionInfoResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SessionInfoResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SessionInfoResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static SessionInfoResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static SessionInfoResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SessionInfoResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static SessionInfoResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SessionInfoResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static SessionInfoResponse parseFrom(InputStream inputStream) throws IOException {
            return (SessionInfoResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SessionInfoResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SessionInfoResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SessionInfoResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static SessionInfoResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static SessionInfoResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static SessionInfoResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<SessionInfoResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof SessionInfoResponse) {
                SessionInfoResponse sessionInfoResponse = (SessionInfoResponse) obj;
                return this.code_ == sessionInfoResponse.code_ && getMessage().equals(sessionInfoResponse.getMessage()) && getName().equals(sessionInfoResponse.getName()) && getDescription().equals(sessionInfoResponse.getDescription()) && getAvatar().equals(sessionInfoResponse.getAvatar()) && getNote().equals(sessionInfoResponse.getNote()) && getVbadge() == sessionInfoResponse.getVbadge() && getVipAnnual() == sessionInfoResponse.getVipAnnual() && getVipGrade() == sessionInfoResponse.getVipGrade() && getVipExpLvl() == sessionInfoResponse.getVipExpLvl() && getIsHideVipLook() == sessionInfoResponse.getIsHideVipLook() && getOVipGrade() == sessionInfoResponse.getOVipGrade() && getOIsHideVipLook() == sessionInfoResponse.getOIsHideVipLook() && getError() == sessionInfoResponse.getError() && getOFaceStatus() == sessionInfoResponse.getOFaceStatus() && this.unknownFields.equals(sessionInfoResponse.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public String getAvatar() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public ByteString getAvatarBytes() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.avatar_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public ReqCode.Code getCode() {
            ReqCode.Code valueOf = ReqCode.Code.valueOf(this.code_);
            ReqCode.Code code = valueOf;
            if (valueOf == null) {
                code = ReqCode.Code.UNRECOGNIZED;
            }
            return code;
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public int getCodeValue() {
            return this.code_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SessionInfoResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public String getDescription() {
            Object obj = this.description_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.description_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public ByteString getDescriptionBytes() {
            Object obj = this.description_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.description_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public long getError() {
            return this.error_;
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public boolean getIsHideVipLook() {
            return this.isHideVipLook_;
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public String getMessage() {
            Object obj = this.message_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.message_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public ByteString getMessageBytes() {
            Object obj = this.message_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.message_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public String getNote() {
            Object obj = this.note_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.note_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public ByteString getNoteBytes() {
            Object obj = this.note_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.note_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public long getOFaceStatus() {
            return this.oFaceStatus_;
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public boolean getOIsHideVipLook() {
            return this.oIsHideVipLook_;
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public long getOVipGrade() {
            return this.oVipGrade_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SessionInfoResponse> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.code_ != ReqCode.Code.REQ_SUCCESS.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.code_);
            }
            int i3 = i2;
            if (!getMessageBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.message_);
            }
            int i4 = i3;
            if (!getNameBytes().isEmpty()) {
                i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.name_);
            }
            int i5 = i4;
            if (!getDescriptionBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(4, this.description_);
            }
            int i6 = i5;
            if (!getAvatarBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(5, this.avatar_);
            }
            int i7 = i6;
            if (!getNoteBytes().isEmpty()) {
                i7 = i6 + GeneratedMessageV3.computeStringSize(6, this.note_);
            }
            long j = this.vbadge_;
            int i8 = i7;
            if (j != 0) {
                i8 = i7 + CodedOutputStream.computeInt64Size(7, j);
            }
            long j2 = this.vipAnnual_;
            int i9 = i8;
            if (j2 != 0) {
                i9 = i8 + CodedOutputStream.computeInt64Size(8, j2);
            }
            long j3 = this.vipGrade_;
            int i10 = i9;
            if (j3 != 0) {
                i10 = i9 + CodedOutputStream.computeInt64Size(9, j3);
            }
            long j4 = this.vipExpLvl_;
            int i11 = i10;
            if (j4 != 0) {
                i11 = i10 + CodedOutputStream.computeInt64Size(10, j4);
            }
            boolean z = this.isHideVipLook_;
            int i12 = i11;
            if (z) {
                i12 = i11 + CodedOutputStream.computeBoolSize(11, z);
            }
            long j5 = this.oVipGrade_;
            int i13 = i12;
            if (j5 != 0) {
                i13 = i12 + CodedOutputStream.computeInt64Size(12, j5);
            }
            boolean z2 = this.oIsHideVipLook_;
            int i14 = i13;
            if (z2) {
                i14 = i13 + CodedOutputStream.computeBoolSize(13, z2);
            }
            long j6 = this.error_;
            int i15 = i14;
            if (j6 != 0) {
                i15 = i14 + CodedOutputStream.computeInt64Size(14, j6);
            }
            long j7 = this.oFaceStatus_;
            int i16 = i15;
            if (j7 != 0) {
                i16 = i15 + CodedOutputStream.computeInt64Size(15, j7);
            }
            int serializedSize = i16 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public long getVbadge() {
            return this.vbadge_;
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public long getVipAnnual() {
            return this.vipAnnual_;
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public long getVipExpLvl() {
            return this.vipExpLvl_;
        }

        @Override // com.blued.im.req.ReqOuterClass.SessionInfoResponseOrBuilder
        public long getVipGrade() {
            return this.vipGrade_;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.code_) * 37) + 2) * 53) + getMessage().hashCode()) * 37) + 3) * 53) + getName().hashCode()) * 37) + 4) * 53) + getDescription().hashCode()) * 37) + 5) * 53) + getAvatar().hashCode()) * 37) + 6) * 53) + getNote().hashCode()) * 37) + 7) * 53) + Internal.hashLong(getVbadge())) * 37) + 8) * 53) + Internal.hashLong(getVipAnnual())) * 37) + 9) * 53) + Internal.hashLong(getVipGrade())) * 37) + 10) * 53) + Internal.hashLong(getVipExpLvl())) * 37) + 11) * 53) + Internal.hashBoolean(getIsHideVipLook())) * 37) + 12) * 53) + Internal.hashLong(getOVipGrade())) * 37) + 13) * 53) + Internal.hashBoolean(getOIsHideVipLook())) * 37) + 14) * 53) + Internal.hashLong(getError())) * 37) + 15) * 53) + Internal.hashLong(getOFaceStatus())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ReqOuterClass.internal_static_com_blued_im_req_SessionInfoResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(SessionInfoResponse.class, Builder.class);
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
            return new SessionInfoResponse();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.code_ != ReqCode.Code.REQ_SUCCESS.getNumber()) {
                codedOutputStream.writeEnum(1, this.code_);
            }
            if (!getMessageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.message_);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.name_);
            }
            if (!getDescriptionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.description_);
            }
            if (!getAvatarBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.avatar_);
            }
            if (!getNoteBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.note_);
            }
            long j = this.vbadge_;
            if (j != 0) {
                codedOutputStream.writeInt64(7, j);
            }
            long j2 = this.vipAnnual_;
            if (j2 != 0) {
                codedOutputStream.writeInt64(8, j2);
            }
            long j3 = this.vipGrade_;
            if (j3 != 0) {
                codedOutputStream.writeInt64(9, j3);
            }
            long j4 = this.vipExpLvl_;
            if (j4 != 0) {
                codedOutputStream.writeInt64(10, j4);
            }
            boolean z = this.isHideVipLook_;
            if (z) {
                codedOutputStream.writeBool(11, z);
            }
            long j5 = this.oVipGrade_;
            if (j5 != 0) {
                codedOutputStream.writeInt64(12, j5);
            }
            boolean z2 = this.oIsHideVipLook_;
            if (z2) {
                codedOutputStream.writeBool(13, z2);
            }
            long j6 = this.error_;
            if (j6 != 0) {
                codedOutputStream.writeInt64(14, j6);
            }
            long j7 = this.oFaceStatus_;
            if (j7 != 0) {
                codedOutputStream.writeInt64(15, j7);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqOuterClass$SessionInfoResponseOrBuilder.class */
    public interface SessionInfoResponseOrBuilder extends MessageOrBuilder {
        String getAvatar();

        ByteString getAvatarBytes();

        ReqCode.Code getCode();

        int getCodeValue();

        String getDescription();

        ByteString getDescriptionBytes();

        long getError();

        boolean getIsHideVipLook();

        String getMessage();

        ByteString getMessageBytes();

        String getName();

        ByteString getNameBytes();

        String getNote();

        ByteString getNoteBytes();

        long getOFaceStatus();

        boolean getOIsHideVipLook();

        long getOVipGrade();

        long getVbadge();

        long getVipAnnual();

        long getVipExpLvl();

        long getVipGrade();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_im_req_RequestBody_descriptor = descriptor2;
        internal_static_com_blued_im_req_RequestBody_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"SessionId", "SessionType", "MsgId"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_blued_im_req_Request_descriptor = descriptor3;
        internal_static_com_blued_im_req_Request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Common", "UserId", "LocalId", "ReqType", "Body"});
        Descriptors.Descriptor descriptor4 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_blued_im_req_Response_descriptor = descriptor4;
        internal_static_com_blued_im_req_Response_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Code", "Message"});
        Descriptors.Descriptor descriptor5 = getDescriptor().getMessageTypes().get(3);
        internal_static_com_blued_im_req_SessionInfoResponse_descriptor = descriptor5;
        internal_static_com_blued_im_req_SessionInfoResponse_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"Code", "Message", "Name", "Description", "Avatar", "Note", "Vbadge", "VipAnnual", "VipGrade", "VipExpLvl", "IsHideVipLook", "OVipGrade", "OIsHideVipLook", "Error", "OFaceStatus"});
        ReqCode.getDescriptor();
        CommonOuterClass.getDescriptor();
    }

    private ReqOuterClass() {
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
