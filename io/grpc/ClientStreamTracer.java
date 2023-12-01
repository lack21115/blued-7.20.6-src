package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/ClientStreamTracer.class */
public abstract class ClientStreamTracer extends StreamTracer {

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/ClientStreamTracer$Factory.class */
    public static abstract class Factory {
        @Deprecated
        public ClientStreamTracer newClientStreamTracer(CallOptions callOptions, Metadata metadata) {
            throw new UnsupportedOperationException("Not implemented");
        }

        public ClientStreamTracer newClientStreamTracer(StreamInfo streamInfo, Metadata metadata) {
            return newClientStreamTracer(streamInfo.getCallOptions(), metadata);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/ClientStreamTracer$StreamInfo.class */
    public static final class StreamInfo {
        private final CallOptions callOptions;
        private final Attributes transportAttrs;

        /* loaded from: source-8829756-dex2jar.jar:io/grpc/ClientStreamTracer$StreamInfo$Builder.class */
        public static final class Builder {
            private Attributes transportAttrs = Attributes.EMPTY;
            private CallOptions callOptions = CallOptions.DEFAULT;

            Builder() {
            }

            public StreamInfo build() {
                return new StreamInfo(this.transportAttrs, this.callOptions);
            }

            public Builder setCallOptions(CallOptions callOptions) {
                this.callOptions = (CallOptions) Preconditions.checkNotNull(callOptions, "callOptions cannot be null");
                return this;
            }

            public Builder setTransportAttrs(Attributes attributes) {
                this.transportAttrs = (Attributes) Preconditions.checkNotNull(attributes, "transportAttrs cannot be null");
                return this;
            }
        }

        StreamInfo(Attributes attributes, CallOptions callOptions) {
            this.transportAttrs = (Attributes) Preconditions.checkNotNull(attributes, "transportAttrs");
            this.callOptions = (CallOptions) Preconditions.checkNotNull(callOptions, "callOptions");
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public CallOptions getCallOptions() {
            return this.callOptions;
        }

        public Attributes getTransportAttrs() {
            return this.transportAttrs;
        }

        public Builder toBuilder() {
            Builder builder = new Builder();
            builder.setTransportAttrs(this.transportAttrs);
            builder.setCallOptions(this.callOptions);
            return builder;
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("transportAttrs", this.transportAttrs).add("callOptions", this.callOptions).toString();
        }
    }

    public void inboundHeaders() {
    }

    public void inboundTrailers(Metadata metadata) {
    }

    public void outboundHeaders() {
    }
}
