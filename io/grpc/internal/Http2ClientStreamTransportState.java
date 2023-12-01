package io.grpc.internal;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import io.grpc.InternalMetadata;
import io.grpc.InternalStatus;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.AbstractClientStream;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/Http2ClientStreamTransportState.class */
public abstract class Http2ClientStreamTransportState extends AbstractClientStream.TransportState {
    private static final Metadata.Key<Integer> HTTP2_STATUS;
    private static final InternalMetadata.TrustedAsciiMarshaller<Integer> HTTP_STATUS_MARSHALLER;
    private Charset errorCharset;
    private boolean headersReceived;
    private Status transportError;
    private Metadata transportErrorMetadata;

    static {
        InternalMetadata.TrustedAsciiMarshaller<Integer> trustedAsciiMarshaller = new InternalMetadata.TrustedAsciiMarshaller<Integer>() { // from class: io.grpc.internal.Http2ClientStreamTransportState.1
            /* renamed from: parseAsciiString */
            public Integer m11416parseAsciiString(byte[] bArr) {
                if (bArr.length >= 3) {
                    return Integer.valueOf(((bArr[0] - 48) * 100) + ((bArr[1] - 48) * 10) + (bArr[2] - 48));
                }
                throw new NumberFormatException("Malformed status code " + new String(bArr, InternalMetadata.US_ASCII));
            }

            public byte[] toAsciiString(Integer num) {
                throw new UnsupportedOperationException();
            }
        };
        HTTP_STATUS_MARSHALLER = trustedAsciiMarshaller;
        HTTP2_STATUS = InternalMetadata.keyOf(":status", trustedAsciiMarshaller);
    }

    public Http2ClientStreamTransportState(int i, StatsTraceContext statsTraceContext, TransportTracer transportTracer) {
        super(i, statsTraceContext, transportTracer);
        this.errorCharset = Charsets.UTF_8;
    }

    private static Charset extractCharset(Metadata metadata) {
        String str = (String) metadata.get(GrpcUtil.CONTENT_TYPE_KEY);
        if (str != null) {
            String[] split = str.split("charset=", 2);
            try {
                return Charset.forName(split[split.length - 1].trim());
            } catch (Exception e) {
            }
        }
        return Charsets.UTF_8;
    }

    private Status statusFromTrailers(Metadata metadata) {
        Status status = (Status) metadata.get(InternalStatus.CODE_KEY);
        if (status != null) {
            return status.withDescription((String) metadata.get(InternalStatus.MESSAGE_KEY));
        }
        if (this.headersReceived) {
            return Status.UNKNOWN.withDescription("missing GRPC status in response");
        }
        Integer num = (Integer) metadata.get(HTTP2_STATUS);
        return (num != null ? GrpcUtil.httpStatusToGrpcStatus(num.intValue()) : Status.INTERNAL.withDescription("missing HTTP status code")).augmentDescription("missing GRPC status, inferred error from HTTP status code");
    }

    private static void stripTransportDetails(Metadata metadata) {
        metadata.discardAll(HTTP2_STATUS);
        metadata.discardAll(InternalStatus.CODE_KEY);
        metadata.discardAll(InternalStatus.MESSAGE_KEY);
    }

    @Nullable
    private Status validateInitialMetadata(Metadata metadata) {
        Integer num = (Integer) metadata.get(HTTP2_STATUS);
        if (num == null) {
            return Status.INTERNAL.withDescription("Missing HTTP status code");
        }
        String str = (String) metadata.get(GrpcUtil.CONTENT_TYPE_KEY);
        if (GrpcUtil.isGrpcContentType(str)) {
            return null;
        }
        Status httpStatusToGrpcStatus = GrpcUtil.httpStatusToGrpcStatus(num.intValue());
        return httpStatusToGrpcStatus.augmentDescription("invalid content-type: " + str);
    }

    @Override // io.grpc.internal.AbstractClientStream.TransportState, io.grpc.internal.MessageDeframer.Listener
    public /* bridge */ /* synthetic */ void deframerClosed(boolean z) {
        super.deframerClosed(z);
    }

    protected abstract void http2ProcessingFailed(Status status, boolean z, Metadata metadata);

    public void transportDataReceived(ReadableBuffer readableBuffer, boolean z) {
        Status status = this.transportError;
        if (status != null) {
            this.transportError = status.augmentDescription("DATA-----------------------------\n" + ReadableBuffers.readAsString(readableBuffer, this.errorCharset));
            readableBuffer.close();
            if (this.transportError.getDescription().length() > 1000 || z) {
                http2ProcessingFailed(this.transportError, false, this.transportErrorMetadata);
            }
        } else if (!this.headersReceived) {
            http2ProcessingFailed(Status.INTERNAL.withDescription("headers not received before payload"), false, new Metadata());
        } else {
            inboundDataReceived(readableBuffer);
            if (z) {
                this.transportError = Status.INTERNAL.withDescription("Received unexpected EOS on DATA frame from server.");
                Metadata metadata = new Metadata();
                this.transportErrorMetadata = metadata;
                transportReportStatus(this.transportError, false, metadata);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void transportHeadersReceived(Metadata metadata) {
        Status status;
        Preconditions.checkNotNull(metadata, "headers");
        Status status2 = this.transportError;
        if (status2 != null) {
            this.transportError = status2.augmentDescription("headers: " + metadata);
            return;
        }
        try {
            if (this.headersReceived) {
                Status withDescription = Status.INTERNAL.withDescription("Received headers twice");
                this.transportError = withDescription;
                if (withDescription != null) {
                    this.transportError = withDescription.augmentDescription("headers: " + metadata);
                    this.transportErrorMetadata = metadata;
                    this.errorCharset = extractCharset(metadata);
                    return;
                }
                return;
            }
            Integer num = (Integer) metadata.get(HTTP2_STATUS);
            if (num != null && num.intValue() >= 100 && num.intValue() < 200) {
                if (status != null) {
                    return;
                }
                return;
            }
            this.headersReceived = true;
            Status validateInitialMetadata = validateInitialMetadata(metadata);
            this.transportError = validateInitialMetadata;
            if (validateInitialMetadata != null) {
                if (validateInitialMetadata != null) {
                    this.transportError = validateInitialMetadata.augmentDescription("headers: " + metadata);
                    this.transportErrorMetadata = metadata;
                    this.errorCharset = extractCharset(metadata);
                    return;
                }
                return;
            }
            stripTransportDetails(metadata);
            inboundHeadersReceived(metadata);
            Status status3 = this.transportError;
            if (status3 != null) {
                this.transportError = status3.augmentDescription("headers: " + metadata);
                this.transportErrorMetadata = metadata;
                this.errorCharset = extractCharset(metadata);
            }
        } finally {
            status = this.transportError;
            if (status != null) {
                this.transportError = status.augmentDescription("headers: " + metadata);
                this.transportErrorMetadata = metadata;
                this.errorCharset = extractCharset(metadata);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void transportTrailersReceived(Metadata metadata) {
        Preconditions.checkNotNull(metadata, GrpcUtil.TE_TRAILERS);
        if (this.transportError == null && !this.headersReceived) {
            Status validateInitialMetadata = validateInitialMetadata(metadata);
            this.transportError = validateInitialMetadata;
            if (validateInitialMetadata != null) {
                this.transportErrorMetadata = metadata;
            }
        }
        Status status = this.transportError;
        if (status == null) {
            Status statusFromTrailers = statusFromTrailers(metadata);
            stripTransportDetails(metadata);
            inboundTrailersReceived(metadata, statusFromTrailers);
            return;
        }
        Status augmentDescription = status.augmentDescription("trailers: " + metadata);
        this.transportError = augmentDescription;
        http2ProcessingFailed(augmentDescription, false, this.transportErrorMetadata);
    }
}
