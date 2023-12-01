package com.android.server;

import android.os.SystemProperties;
import android.util.Log;
import android.util.Slog;
import dalvik.system.SocketTagger;
import java.io.FileDescriptor;
import java.net.SocketException;

/* loaded from: source-4181928-dex2jar.jar:com/android/server/NetworkManagementSocketTagger.class */
public final class NetworkManagementSocketTagger extends SocketTagger {
    private static final boolean LOGD = false;
    public static final String PROP_QTAGUID_ENABLED = "net.qtaguid_enabled";
    private static final String TAG = "NetworkManagementSocketTagger";
    private static ThreadLocal<SocketTags> threadSocketTags = new ThreadLocal<SocketTags>() { // from class: com.android.server.NetworkManagementSocketTagger.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public SocketTags initialValue() {
            return new SocketTags();
        }
    };

    /* loaded from: source-4181928-dex2jar.jar:com/android/server/NetworkManagementSocketTagger$SocketTags.class */
    public static class SocketTags {
        public int statsTag = -1;
        public int statsUid = -1;
    }

    public static int getThreadSocketStatsTag() {
        return threadSocketTags.get().statsTag;
    }

    public static void install() {
        SocketTagger.set(new NetworkManagementSocketTagger());
    }

    public static int kernelToTag(String str) {
        int i = 0;
        int length = str.length();
        if (length > 10) {
            i = Long.decode(str.substring(0, length - 8)).intValue();
        }
        return i;
    }

    private static native int native_deleteTagData(int i, int i2);

    private static native int native_setCounterSet(int i, int i2);

    private static native int native_tagSocketFd(FileDescriptor fileDescriptor, int i, int i2);

    private static native int native_untagSocketFd(FileDescriptor fileDescriptor);

    public static void resetKernelUidStats(int i) {
        int native_deleteTagData;
        if (!SystemProperties.getBoolean(PROP_QTAGUID_ENABLED, false) || (native_deleteTagData = native_deleteTagData(0, i)) >= 0) {
            return;
        }
        Slog.w(TAG, "problem clearing counters for uid " + i + " : errno " + native_deleteTagData);
    }

    public static void setKernelCounterSet(int i, int i2) {
        int native_setCounterSet;
        if (!SystemProperties.getBoolean(PROP_QTAGUID_ENABLED, false) || (native_setCounterSet = native_setCounterSet(i2, i)) >= 0) {
            return;
        }
        Log.w(TAG, "setKernelCountSet(" + i + ", " + i2 + ") failed with errno " + native_setCounterSet);
    }

    public static void setThreadSocketStatsTag(int i) {
        threadSocketTags.get().statsTag = i;
    }

    public static void setThreadSocketStatsUid(int i) {
        threadSocketTags.get().statsUid = i;
    }

    private void tagSocketFd(FileDescriptor fileDescriptor, int i, int i2) {
        int native_tagSocketFd;
        if (!(i == -1 && i2 == -1) && SystemProperties.getBoolean(PROP_QTAGUID_ENABLED, false) && (native_tagSocketFd = native_tagSocketFd(fileDescriptor, i, i2)) < 0) {
            Log.i(TAG, "tagSocketFd(" + fileDescriptor.getInt$() + ", " + i + ", " + i2 + ") failed with errno" + native_tagSocketFd);
        }
    }

    private void unTagSocketFd(FileDescriptor fileDescriptor) {
        int native_untagSocketFd;
        SocketTags socketTags = threadSocketTags.get();
        if (!(socketTags.statsTag == -1 && socketTags.statsUid == -1) && SystemProperties.getBoolean(PROP_QTAGUID_ENABLED, false) && (native_untagSocketFd = native_untagSocketFd(fileDescriptor)) < 0) {
            Log.w(TAG, "untagSocket(" + fileDescriptor.getInt$() + ") failed with errno " + native_untagSocketFd);
        }
    }

    @Override // dalvik.system.SocketTagger
    public void tag(FileDescriptor fileDescriptor) throws SocketException {
        SocketTags socketTags = threadSocketTags.get();
        tagSocketFd(fileDescriptor, socketTags.statsTag, socketTags.statsUid);
    }

    @Override // dalvik.system.SocketTagger
    public void untag(FileDescriptor fileDescriptor) throws SocketException {
        unTagSocketFd(fileDescriptor);
    }
}
