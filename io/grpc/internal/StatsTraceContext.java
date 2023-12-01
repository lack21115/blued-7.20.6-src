package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.ServerStreamTracer;
import io.grpc.Status;
import io.grpc.StreamTracer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/StatsTraceContext.class */
public final class StatsTraceContext {
    public static final StatsTraceContext NOOP = new StatsTraceContext(new StreamTracer[0]);
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final StreamTracer[] tracers;

    StatsTraceContext(StreamTracer[] streamTracerArr) {
        this.tracers = streamTracerArr;
    }

    public static StatsTraceContext newClientContext(CallOptions callOptions, Attributes attributes, Metadata metadata) {
        List streamTracerFactories = callOptions.getStreamTracerFactories();
        if (streamTracerFactories.isEmpty()) {
            return NOOP;
        }
        ClientStreamTracer.StreamInfo build = ClientStreamTracer.StreamInfo.newBuilder().setTransportAttrs(attributes).setCallOptions(callOptions).build();
        int size = streamTracerFactories.size();
        StreamTracer[] streamTracerArr = new StreamTracer[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return new StatsTraceContext(streamTracerArr);
            }
            streamTracerArr[i2] = ((ClientStreamTracer.Factory) streamTracerFactories.get(i2)).newClientStreamTracer(build, metadata);
            i = i2 + 1;
        }
    }

    public static StatsTraceContext newServerContext(List<? extends ServerStreamTracer.Factory> list, String str, Metadata metadata) {
        if (list.isEmpty()) {
            return NOOP;
        }
        int size = list.size();
        StreamTracer[] streamTracerArr = new StreamTracer[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return new StatsTraceContext(streamTracerArr);
            }
            streamTracerArr[i2] = list.get(i2).newServerStreamTracer(str, metadata);
            i = i2 + 1;
        }
    }

    public void clientInboundHeaders() {
        ClientStreamTracer[] clientStreamTracerArr = this.tracers;
        int length = clientStreamTracerArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            clientStreamTracerArr[i2].inboundHeaders();
            i = i2 + 1;
        }
    }

    public void clientInboundTrailers(Metadata metadata) {
        ClientStreamTracer[] clientStreamTracerArr = this.tracers;
        int length = clientStreamTracerArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            clientStreamTracerArr[i2].inboundTrailers(metadata);
            i = i2 + 1;
        }
    }

    public void clientOutboundHeaders() {
        ClientStreamTracer[] clientStreamTracerArr = this.tracers;
        int length = clientStreamTracerArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            clientStreamTracerArr[i2].outboundHeaders();
            i = i2 + 1;
        }
    }

    public List<StreamTracer> getTracersForTest() {
        return new ArrayList(Arrays.asList(this.tracers));
    }

    public void inboundMessage(int i) {
        StreamTracer[] streamTracerArr = this.tracers;
        int length = streamTracerArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            streamTracerArr[i3].inboundMessage(i);
            i2 = i3 + 1;
        }
    }

    public void inboundMessageRead(int i, long j, long j2) {
        StreamTracer[] streamTracerArr = this.tracers;
        int length = streamTracerArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            streamTracerArr[i3].inboundMessageRead(i, j, j2);
            i2 = i3 + 1;
        }
    }

    public void inboundUncompressedSize(long j) {
        StreamTracer[] streamTracerArr = this.tracers;
        int length = streamTracerArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            streamTracerArr[i2].inboundUncompressedSize(j);
            i = i2 + 1;
        }
    }

    public void inboundWireSize(long j) {
        StreamTracer[] streamTracerArr = this.tracers;
        int length = streamTracerArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            streamTracerArr[i2].inboundWireSize(j);
            i = i2 + 1;
        }
    }

    public void outboundMessage(int i) {
        StreamTracer[] streamTracerArr = this.tracers;
        int length = streamTracerArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            streamTracerArr[i3].outboundMessage(i);
            i2 = i3 + 1;
        }
    }

    public void outboundMessageSent(int i, long j, long j2) {
        StreamTracer[] streamTracerArr = this.tracers;
        int length = streamTracerArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            streamTracerArr[i3].outboundMessageSent(i, j, j2);
            i2 = i3 + 1;
        }
    }

    public void outboundUncompressedSize(long j) {
        StreamTracer[] streamTracerArr = this.tracers;
        int length = streamTracerArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            streamTracerArr[i2].outboundUncompressedSize(j);
            i = i2 + 1;
        }
    }

    public void outboundWireSize(long j) {
        StreamTracer[] streamTracerArr = this.tracers;
        int length = streamTracerArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            streamTracerArr[i2].outboundWireSize(j);
            i = i2 + 1;
        }
    }

    public void serverCallStarted(ServerStreamTracer.ServerCallInfo<?, ?> serverCallInfo) {
        ServerStreamTracer[] serverStreamTracerArr = this.tracers;
        int length = serverStreamTracerArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            serverStreamTracerArr[i2].serverCallStarted(serverCallInfo);
            i = i2 + 1;
        }
    }

    public <ReqT, RespT> Context serverFilterContext(Context context) {
        Context context2 = (Context) Preconditions.checkNotNull(context, "context");
        ServerStreamTracer[] serverStreamTracerArr = this.tracers;
        int length = serverStreamTracerArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return context2;
            }
            ServerStreamTracer serverStreamTracer = serverStreamTracerArr[i2];
            context2 = serverStreamTracer.filterContext(context2);
            Preconditions.checkNotNull(context2, "%s returns null context", serverStreamTracer);
            i = i2 + 1;
        }
    }

    public void streamClosed(Status status) {
        if (this.closed.compareAndSet(false, true)) {
            for (StreamTracer streamTracer : this.tracers) {
                streamTracer.streamClosed(status);
            }
        }
    }
}
