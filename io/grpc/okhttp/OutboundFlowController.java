package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.okhttp.internal.framed.FrameWriter;
import java.io.IOException;
import javax.annotation.Nullable;
import okio.Buffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:io/grpc/okhttp/OutboundFlowController.class */
public class OutboundFlowController {
    private final FrameWriter frameWriter;
    private final OkHttpClientTransport transport;
    private int initialWindowSize = 65535;
    private final OutboundFlowState connectionState = new OutboundFlowState(0, 65535);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/okhttp/OutboundFlowController$OutboundFlowState.class */
    public final class OutboundFlowState {
        int allocatedBytes;
        boolean pendingBufferHasEndOfStream;
        final Buffer pendingWriteBuffer;
        OkHttpClientStream stream;
        final int streamId;
        int window;

        OutboundFlowState(int i, int i2) {
            this.pendingBufferHasEndOfStream = false;
            this.streamId = i;
            this.window = i2;
            this.pendingWriteBuffer = new Buffer();
        }

        OutboundFlowState(OutboundFlowController outboundFlowController, OkHttpClientStream okHttpClientStream, int i) {
            this(okHttpClientStream.id(), i);
            this.stream = okHttpClientStream;
        }

        void allocateBytes(int i) {
            this.allocatedBytes += i;
        }

        int allocatedBytes() {
            return this.allocatedBytes;
        }

        void clearAllocatedBytes() {
            this.allocatedBytes = 0;
        }

        void enqueue(Buffer buffer, int i, boolean z) {
            this.pendingWriteBuffer.write(buffer, i);
            this.pendingBufferHasEndOfStream |= z;
        }

        boolean hasPendingData() {
            return this.pendingWriteBuffer.size() > 0;
        }

        int incrementStreamWindow(int i) {
            if (i <= 0 || Integer.MAX_VALUE - i >= this.window) {
                int i2 = this.window + i;
                this.window = i2;
                return i2;
            }
            throw new IllegalArgumentException("Window size overflow for stream: " + this.streamId);
        }

        int streamableBytes() {
            return Math.max(0, Math.min(this.window, (int) this.pendingWriteBuffer.size()));
        }

        int unallocatedBytes() {
            return streamableBytes() - this.allocatedBytes;
        }

        int window() {
            return this.window;
        }

        int writableWindow() {
            return Math.min(this.window, OutboundFlowController.this.connectionState.window());
        }

        void write(Buffer buffer, int i, boolean z) {
            int i2;
            do {
                int min = Math.min(i, OutboundFlowController.this.frameWriter.maxDataLength());
                int i3 = -min;
                OutboundFlowController.this.connectionState.incrementStreamWindow(i3);
                incrementStreamWindow(i3);
                try {
                    OutboundFlowController.this.frameWriter.data(buffer.size() == ((long) min) && z, this.streamId, buffer, min);
                    this.stream.transportState().onSentBytes(min);
                    i2 = i - min;
                    i = i2;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } while (i2 > 0);
        }

        int writeBytes(int i, WriteStatus writeStatus) {
            int min = Math.min(i, writableWindow());
            int i2 = 0;
            while (hasPendingData() && min > 0) {
                if (min >= this.pendingWriteBuffer.size()) {
                    i2 += (int) this.pendingWriteBuffer.size();
                    Buffer buffer = this.pendingWriteBuffer;
                    write(buffer, (int) buffer.size(), this.pendingBufferHasEndOfStream);
                } else {
                    i2 += min;
                    write(this.pendingWriteBuffer, min, false);
                }
                writeStatus.incrementNumWrites();
                min = Math.min(i - i2, writableWindow());
            }
            return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/okhttp/OutboundFlowController$WriteStatus.class */
    public static final class WriteStatus {
        int numWrites;

        private WriteStatus() {
        }

        boolean hasWritten() {
            return this.numWrites > 0;
        }

        void incrementNumWrites() {
            this.numWrites++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OutboundFlowController(OkHttpClientTransport okHttpClientTransport, FrameWriter frameWriter) {
        this.transport = (OkHttpClientTransport) Preconditions.checkNotNull(okHttpClientTransport, "transport");
        this.frameWriter = (FrameWriter) Preconditions.checkNotNull(frameWriter, "frameWriter");
    }

    private OutboundFlowState state(OkHttpClientStream okHttpClientStream) {
        OutboundFlowState outboundFlowState = (OutboundFlowState) okHttpClientStream.getOutboundFlowState();
        OutboundFlowState outboundFlowState2 = outboundFlowState;
        if (outboundFlowState == null) {
            outboundFlowState2 = new OutboundFlowState(this, okHttpClientStream, this.initialWindowSize);
            okHttpClientStream.setOutboundFlowState(outboundFlowState2);
        }
        return outboundFlowState2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void data(boolean z, int i, Buffer buffer, boolean z2) {
        Preconditions.checkNotNull(buffer, "source");
        OkHttpClientStream stream = this.transport.getStream(i);
        if (stream == null) {
            return;
        }
        OutboundFlowState state = state(stream);
        int writableWindow = state.writableWindow();
        boolean hasPendingData = state.hasPendingData();
        int size = (int) buffer.size();
        if (hasPendingData || writableWindow < size) {
            if (!hasPendingData && writableWindow > 0) {
                state.write(buffer, writableWindow, false);
            }
            state.enqueue(buffer, (int) buffer.size(), z);
        } else {
            state.write(buffer, size, z);
        }
        if (z2) {
            flush();
        }
    }

    void flush() {
        try {
            this.frameWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean initialOutboundWindowSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid initial window size: " + i);
        }
        int i2 = i - this.initialWindowSize;
        this.initialWindowSize = i;
        OkHttpClientStream[] activeStreams = this.transport.getActiveStreams();
        int length = activeStreams.length;
        boolean z = false;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                break;
            }
            OkHttpClientStream okHttpClientStream = activeStreams[i4];
            OutboundFlowState outboundFlowState = (OutboundFlowState) okHttpClientStream.getOutboundFlowState();
            if (outboundFlowState == null) {
                okHttpClientStream.setOutboundFlowState(new OutboundFlowState(this, okHttpClientStream, this.initialWindowSize));
            } else {
                outboundFlowState.incrementStreamWindow(i2);
            }
            i3 = i4 + 1;
        }
        if (i2 > 0) {
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int windowUpdate(@Nullable OkHttpClientStream okHttpClientStream, int i) {
        if (okHttpClientStream == null) {
            int incrementStreamWindow = this.connectionState.incrementStreamWindow(i);
            writeStreams();
            return incrementStreamWindow;
        }
        OutboundFlowState state = state(okHttpClientStream);
        int incrementStreamWindow2 = state.incrementStreamWindow(i);
        WriteStatus writeStatus = new WriteStatus();
        state.writeBytes(state.writableWindow(), writeStatus);
        if (writeStatus.hasWritten()) {
            flush();
        }
        return incrementStreamWindow2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeStreams() {
        OkHttpClientStream[] activeStreams = this.transport.getActiveStreams();
        int window = this.connectionState.window();
        int length = activeStreams.length;
        while (true) {
            int i = length;
            int i2 = 0;
            if (i <= 0 || window <= 0) {
                break;
            }
            int ceil = (int) Math.ceil(window / i);
            int i3 = 0;
            while (i3 < i && window > 0) {
                OkHttpClientStream okHttpClientStream = activeStreams[i3];
                OutboundFlowState state = state(okHttpClientStream);
                int min = Math.min(window, Math.min(state.unallocatedBytes(), ceil));
                int i4 = window;
                if (min > 0) {
                    state.allocateBytes(min);
                    i4 = window - min;
                }
                int i5 = i2;
                if (state.unallocatedBytes() > 0) {
                    activeStreams[i2] = okHttpClientStream;
                    i5 = i2 + 1;
                }
                i3++;
                window = i4;
                i2 = i5;
            }
            length = i2;
        }
        WriteStatus writeStatus = new WriteStatus();
        OkHttpClientStream[] activeStreams2 = this.transport.getActiveStreams();
        int length2 = activeStreams2.length;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= length2) {
                break;
            }
            OutboundFlowState state2 = state(activeStreams2[i7]);
            state2.writeBytes(state2.allocatedBytes(), writeStatus);
            state2.clearAllocatedBytes();
            i6 = i7 + 1;
        }
        if (writeStatus.hasWritten()) {
            flush();
        }
    }
}
