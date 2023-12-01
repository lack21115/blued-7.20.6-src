package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.Settings;
import java.util.EnumMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:io/grpc/okhttp/OkHttpFrameLogger.class */
public class OkHttpFrameLogger {
    private static final int BUFFER_LENGTH_THRESHOLD = 64;
    private final Level level;
    private final Logger logger;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/okhttp/OkHttpFrameLogger$Direction.class */
    public enum Direction {
        INBOUND,
        OUTBOUND
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/grpc/okhttp/OkHttpFrameLogger$SettingParams.class */
    public enum SettingParams {
        HEADER_TABLE_SIZE(1),
        ENABLE_PUSH(2),
        MAX_CONCURRENT_STREAMS(4),
        MAX_FRAME_SIZE(5),
        MAX_HEADER_LIST_SIZE(6),
        INITIAL_WINDOW_SIZE(7);
        
        private final int bit;

        SettingParams(int i) {
            this.bit = i;
        }

        public int getBit() {
            return this.bit;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OkHttpFrameLogger(Level level, Class<?> cls) {
        this(level, Logger.getLogger(cls.getName()));
    }

    OkHttpFrameLogger(Level level, Logger logger) {
        this.level = (Level) Preconditions.checkNotNull(level, "level");
        this.logger = (Logger) Preconditions.checkNotNull(logger, "logger");
    }

    private boolean isEnabled() {
        return this.logger.isLoggable(this.level);
    }

    private static String toString(Settings settings) {
        EnumMap enumMap = new EnumMap(SettingParams.class);
        SettingParams[] values = SettingParams.values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return enumMap.toString();
            }
            SettingParams settingParams = values[i2];
            if (settings.isSet(settingParams.getBit())) {
                enumMap.put((EnumMap) settingParams, (SettingParams) Integer.valueOf(settings.get(settingParams.getBit())));
            }
            i = i2 + 1;
        }
    }

    private static String toString(Buffer buffer) {
        if (buffer.size() <= 64) {
            return buffer.snapshot().hex();
        }
        int min = (int) Math.min(buffer.size(), 64L);
        return buffer.snapshot(min).hex() + "...";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void logData(Direction direction, int i, Buffer buffer, int i2, boolean z) {
        if (isEnabled()) {
            Logger logger = this.logger;
            Level level = this.level;
            logger.log(level, direction + " DATA: streamId=" + i + " endStream=" + z + " length=" + i2 + " bytes=" + toString(buffer));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void logGoAway(Direction direction, int i, ErrorCode errorCode, ByteString byteString) {
        if (isEnabled()) {
            Logger logger = this.logger;
            Level level = this.level;
            logger.log(level, direction + " GO_AWAY: lastStreamId=" + i + " errorCode=" + errorCode + " length=" + byteString.size() + " bytes=" + toString(new Buffer().write(byteString)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void logHeaders(Direction direction, int i, List<Header> list, boolean z) {
        if (isEnabled()) {
            Logger logger = this.logger;
            Level level = this.level;
            logger.log(level, direction + " HEADERS: streamId=" + i + " headers=" + list + " endStream=" + z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void logPing(Direction direction, long j) {
        if (isEnabled()) {
            Logger logger = this.logger;
            Level level = this.level;
            logger.log(level, direction + " PING: ack=false bytes=" + j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void logPingAck(Direction direction, long j) {
        if (isEnabled()) {
            Logger logger = this.logger;
            Level level = this.level;
            logger.log(level, direction + " PING: ack=true bytes=" + j);
        }
    }

    public void logPriority(Direction direction, int i, int i2, int i3, boolean z) {
        if (isEnabled()) {
            Logger logger = this.logger;
            Level level = this.level;
            logger.log(level, direction + " PRIORITY: streamId=" + i + " streamDependency=" + i2 + " weight=" + i3 + " exclusive=" + z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void logPushPromise(Direction direction, int i, int i2, List<Header> list) {
        if (isEnabled()) {
            Logger logger = this.logger;
            Level level = this.level;
            logger.log(level, direction + " PUSH_PROMISE: streamId=" + i + " promisedStreamId=" + i2 + " headers=" + list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void logRstStream(Direction direction, int i, ErrorCode errorCode) {
        if (isEnabled()) {
            Logger logger = this.logger;
            Level level = this.level;
            logger.log(level, direction + " RST_STREAM: streamId=" + i + " errorCode=" + errorCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void logSettings(Direction direction, Settings settings) {
        if (isEnabled()) {
            Logger logger = this.logger;
            Level level = this.level;
            logger.log(level, direction + " SETTINGS: ack=false settings=" + toString(settings));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void logSettingsAck(Direction direction) {
        if (isEnabled()) {
            Logger logger = this.logger;
            Level level = this.level;
            logger.log(level, direction + " SETTINGS: ack=true");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void logWindowsUpdate(Direction direction, int i, long j) {
        if (isEnabled()) {
            Logger logger = this.logger;
            Level level = this.level;
            logger.log(level, direction + " WINDOW_UPDATE: streamId=" + i + " windowSizeIncrement=" + j);
        }
    }
}
