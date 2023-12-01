package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.ForwardingServerCallListener;
import io.grpc.ServerCall;
import io.grpc.Status;
import java.util.concurrent.TimeoutException;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/Contexts.class */
public final class Contexts {

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Contexts$ContextualizedServerCallListener.class */
    static class ContextualizedServerCallListener<ReqT> extends ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT> {
        private final Context context;

        public ContextualizedServerCallListener(ServerCall.Listener<ReqT> listener, Context context) {
            super(listener);
            this.context = context;
        }

        @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
        public void onCancel() {
            Context attach = this.context.attach();
            try {
                super.onCancel();
            } finally {
                this.context.detach(attach);
            }
        }

        @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
        public void onComplete() {
            Context attach = this.context.attach();
            try {
                super.onComplete();
            } finally {
                this.context.detach(attach);
            }
        }

        @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
        public void onHalfClose() {
            Context attach = this.context.attach();
            try {
                super.onHalfClose();
            } finally {
                this.context.detach(attach);
            }
        }

        @Override // io.grpc.ForwardingServerCallListener, io.grpc.ServerCall.Listener
        public void onMessage(ReqT reqt) {
            Context attach = this.context.attach();
            try {
                super.onMessage(reqt);
            } finally {
                this.context.detach(attach);
            }
        }

        @Override // io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener, io.grpc.ForwardingServerCallListener, io.grpc.PartialForwardingServerCallListener, io.grpc.ServerCall.Listener
        public void onReady() {
            Context attach = this.context.attach();
            try {
                super.onReady();
            } finally {
                this.context.detach(attach);
            }
        }
    }

    private Contexts() {
    }

    public static <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(Context context, ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        Context attach = context.attach();
        try {
            return new ContextualizedServerCallListener(serverCallHandler.startCall(serverCall, metadata), context);
        } finally {
            context.detach(attach);
        }
    }

    public static Status statusFromCancelled(Context context) {
        Preconditions.checkNotNull(context, "context must not be null");
        if (context.isCancelled()) {
            Throwable cancellationCause = context.cancellationCause();
            if (cancellationCause == null) {
                return Status.CANCELLED.withDescription("io.grpc.Context was cancelled without error");
            }
            if (cancellationCause instanceof TimeoutException) {
                return Status.DEADLINE_EXCEEDED.withDescription(cancellationCause.getMessage()).withCause(cancellationCause);
            }
            Status fromThrowable = Status.fromThrowable(cancellationCause);
            return (Status.Code.UNKNOWN.equals(fromThrowable.getCode()) && fromThrowable.getCause() == cancellationCause) ? Status.CANCELLED.withDescription("Context cancelled").withCause(cancellationCause) : fromThrowable.withCause(cancellationCause);
        }
        return null;
    }
}
