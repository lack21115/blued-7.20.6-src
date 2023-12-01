package org.apache.harmony.dalvik.ddmc;

import java.util.HashMap;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/dalvik/ddmc/DdmServer.class */
public class DdmServer {
    public static final int CLIENT_PROTOCOL_VERSION = 1;
    private static final int CONNECTED = 1;
    private static final int DISCONNECTED = 2;
    private static HashMap<Integer, ChunkHandler> mHandlerMap = new HashMap<>();
    private static volatile boolean mRegistrationComplete = false;
    private static boolean mRegistrationTimedOut = false;

    private DdmServer() {
    }

    private static void broadcast(int i) {
        synchronized (mHandlerMap) {
            for (ChunkHandler chunkHandler : mHandlerMap.values()) {
                switch (i) {
                    case 1:
                        chunkHandler.connected();
                        break;
                    case 2:
                        chunkHandler.disconnected();
                        break;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }
    }

    private static Chunk dispatch(int i, byte[] bArr, int i2, int i3) {
        ChunkHandler chunkHandler;
        synchronized (mHandlerMap) {
            while (!mRegistrationComplete && !mRegistrationTimedOut) {
                try {
                    mHandlerMap.wait(1000L);
                    if (!mRegistrationComplete) {
                        mRegistrationTimedOut = true;
                    }
                } catch (InterruptedException e) {
                }
            }
            chunkHandler = mHandlerMap.get(Integer.valueOf(i));
        }
        if (chunkHandler == null) {
            return null;
        }
        return chunkHandler.handleChunk(new Chunk(i, bArr, i2, i3));
    }

    private static native void nativeSendChunk(int i, byte[] bArr, int i2, int i3);

    public static void registerHandler(int i, ChunkHandler chunkHandler) {
        if (chunkHandler == null) {
            throw new NullPointerException("handler == null");
        }
        synchronized (mHandlerMap) {
            if (mHandlerMap.get(Integer.valueOf(i)) != null) {
                throw new RuntimeException("type " + Integer.toHexString(i) + " already registered");
            }
            mHandlerMap.put(Integer.valueOf(i), chunkHandler);
        }
    }

    public static void registrationComplete() {
        synchronized (mHandlerMap) {
            mRegistrationComplete = true;
            mHandlerMap.notifyAll();
        }
    }

    public static void sendChunk(Chunk chunk) {
        nativeSendChunk(chunk.type, chunk.data, chunk.offset, chunk.length);
    }

    public static ChunkHandler unregisterHandler(int i) {
        ChunkHandler remove;
        synchronized (mHandlerMap) {
            remove = mHandlerMap.remove(Integer.valueOf(i));
        }
        return remove;
    }
}
