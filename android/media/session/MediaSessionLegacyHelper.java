package android.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadata;
import android.media.MediaMetadataEditor;
import android.media.Rating;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.ArrayMap;
import android.util.Log;
import android.view.KeyEvent;

/* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaSessionLegacyHelper.class */
public class MediaSessionLegacyHelper {
    private static MediaSessionLegacyHelper sInstance;
    private Context mContext;
    private MediaSessionManager mSessionManager;
    private static final String TAG = "MediaSessionHelper";
    private static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final Object sLock = new Object();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayMap<PendingIntent, SessionHolder> mSessions = new ArrayMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaSessionLegacyHelper$MediaButtonListener.class */
    public static final class MediaButtonListener extends MediaSession.Callback {
        private final Context mContext;
        private final PendingIntent mPendingIntent;

        public MediaButtonListener(PendingIntent pendingIntent, Context context) {
            this.mPendingIntent = pendingIntent;
            this.mContext = context;
        }

        private void sendKeyEvent(int i) {
            KeyEvent keyEvent = new KeyEvent(0, i);
            Intent intent = new Intent(Intent.ACTION_MEDIA_BUTTON);
            intent.addFlags(268435456);
            intent.putExtra(Intent.EXTRA_KEY_EVENT, keyEvent);
            MediaSessionLegacyHelper.sendKeyEvent(this.mPendingIntent, this.mContext, intent);
            intent.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(1, i));
            MediaSessionLegacyHelper.sendKeyEvent(this.mPendingIntent, this.mContext, intent);
            if (MediaSessionLegacyHelper.DEBUG) {
                Log.d(MediaSessionLegacyHelper.TAG, "Sent " + i + " to pending intent " + this.mPendingIntent);
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onFastForward() {
            sendKeyEvent(90);
        }

        @Override // android.media.session.MediaSession.Callback
        public boolean onMediaButtonEvent(Intent intent) {
            MediaSessionLegacyHelper.sendKeyEvent(this.mPendingIntent, this.mContext, intent);
            return true;
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPause() {
            sendKeyEvent(127);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlay() {
            sendKeyEvent(126);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onRewind() {
            sendKeyEvent(89);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToNext() {
            sendKeyEvent(87);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToPrevious() {
            sendKeyEvent(88);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onStop() {
            sendKeyEvent(86);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaSessionLegacyHelper$SessionHolder.class */
    public class SessionHolder {
        public SessionCallback mCb;
        public int mFlags;
        public MediaButtonListener mMediaButtonListener;
        public final PendingIntent mPi;
        public MediaSession.Callback mRccListener;
        public final MediaSession mSession;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/media/session/MediaSessionLegacyHelper$SessionHolder$SessionCallback.class */
        public class SessionCallback extends MediaSession.Callback {
            private SessionCallback() {
            }

            @Override // android.media.session.MediaSession.Callback
            public void getNowPlayingEntries() {
                if (SessionHolder.this.mRccListener != null) {
                    SessionHolder.this.mRccListener.getNowPlayingEntries();
                }
            }

            @Override // android.media.session.MediaSession.Callback
            public void onFastForward() {
                if (SessionHolder.this.mMediaButtonListener != null) {
                    SessionHolder.this.mMediaButtonListener.onFastForward();
                }
            }

            @Override // android.media.session.MediaSession.Callback
            public boolean onMediaButtonEvent(Intent intent) {
                if (SessionHolder.this.mMediaButtonListener != null) {
                    SessionHolder.this.mMediaButtonListener.onMediaButtonEvent(intent);
                    return true;
                }
                return true;
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPause() {
                if (SessionHolder.this.mMediaButtonListener != null) {
                    SessionHolder.this.mMediaButtonListener.onPause();
                }
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlay() {
                if (SessionHolder.this.mMediaButtonListener != null) {
                    SessionHolder.this.mMediaButtonListener.onPlay();
                }
            }

            @Override // android.media.session.MediaSession.Callback
            public void onRewind() {
                if (SessionHolder.this.mMediaButtonListener != null) {
                    SessionHolder.this.mMediaButtonListener.onRewind();
                }
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSeekTo(long j) {
                if (SessionHolder.this.mRccListener != null) {
                    SessionHolder.this.mRccListener.onSeekTo(j);
                }
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSetRating(Rating rating) {
                if (SessionHolder.this.mRccListener != null) {
                    SessionHolder.this.mRccListener.onSetRating(rating);
                }
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToNext() {
                if (SessionHolder.this.mMediaButtonListener != null) {
                    SessionHolder.this.mMediaButtonListener.onSkipToNext();
                }
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToPrevious() {
                if (SessionHolder.this.mMediaButtonListener != null) {
                    SessionHolder.this.mMediaButtonListener.onSkipToPrevious();
                }
            }

            @Override // android.media.session.MediaSession.Callback
            public void onStop() {
                if (SessionHolder.this.mMediaButtonListener != null) {
                    SessionHolder.this.mMediaButtonListener.onStop();
                }
            }

            @Override // android.media.session.MediaSession.Callback
            public void setBrowsedPlayer() {
                if (SessionHolder.this.mRccListener != null) {
                    SessionHolder.this.mRccListener.setBrowsedPlayer();
                }
            }

            @Override // android.media.session.MediaSession.Callback
            public void setPlayItem(int i, long j) {
                if (SessionHolder.this.mRccListener != null) {
                    SessionHolder.this.mRccListener.setPlayItem(i, j);
                }
            }
        }

        public SessionHolder(MediaSession mediaSession, PendingIntent pendingIntent) {
            this.mSession = mediaSession;
            this.mPi = pendingIntent;
        }

        public void update() {
            if (this.mMediaButtonListener == null && this.mRccListener == null) {
                this.mSession.setCallback(null);
                this.mSession.release();
                this.mCb = null;
                MediaSessionLegacyHelper.this.mSessions.remove(this.mPi);
            } else if (this.mCb == null) {
                this.mCb = new SessionCallback();
                this.mSession.setCallback(this.mCb, new Handler(Looper.getMainLooper()));
            }
        }
    }

    private MediaSessionLegacyHelper(Context context) {
        this.mContext = context;
        this.mSessionManager = (MediaSessionManager) context.getSystemService(Context.MEDIA_SESSION_SERVICE);
    }

    public static MediaSessionLegacyHelper getHelper(Context context) {
        synchronized (sLock) {
            if (sInstance == null) {
                sInstance = new MediaSessionLegacyHelper(context.getApplicationContext());
            }
        }
        return sInstance;
    }

    private SessionHolder getHolder(PendingIntent pendingIntent, boolean z) {
        SessionHolder sessionHolder = this.mSessions.get(pendingIntent);
        SessionHolder sessionHolder2 = sessionHolder;
        if (sessionHolder == null) {
            sessionHolder2 = sessionHolder;
            if (z) {
                MediaSession mediaSession = new MediaSession(this.mContext, "MediaSessionHelper-" + pendingIntent.getCreatorPackage());
                mediaSession.setActive(true);
                sessionHolder2 = new SessionHolder(mediaSession, pendingIntent);
                this.mSessions.put(pendingIntent, sessionHolder2);
            }
        }
        return sessionHolder2;
    }

    public static Bundle getOldMetadata(MediaMetadata mediaMetadata, int i, int i2) {
        boolean z = (i == -1 || i2 == -1) ? false : true;
        Bundle bundle = new Bundle();
        if (mediaMetadata.containsKey("android.media.metadata.ALBUM")) {
            bundle.putString(String.valueOf(1), mediaMetadata.getString("android.media.metadata.ALBUM"));
        }
        if (z && mediaMetadata.containsKey("android.media.metadata.ART")) {
            bundle.putParcelable(String.valueOf(100), scaleBitmapIfTooBig(mediaMetadata.getBitmap("android.media.metadata.ART"), i, i2));
        } else if (z && mediaMetadata.containsKey("android.media.metadata.ALBUM_ART")) {
            bundle.putParcelable(String.valueOf(100), scaleBitmapIfTooBig(mediaMetadata.getBitmap("android.media.metadata.ALBUM_ART"), i, i2));
        }
        if (mediaMetadata.containsKey("android.media.metadata.ALBUM_ARTIST")) {
            bundle.putString(String.valueOf(13), mediaMetadata.getString("android.media.metadata.ALBUM_ARTIST"));
        }
        if (mediaMetadata.containsKey("android.media.metadata.ARTIST")) {
            bundle.putString(String.valueOf(2), mediaMetadata.getString("android.media.metadata.ARTIST"));
        }
        if (mediaMetadata.containsKey("android.media.metadata.AUTHOR")) {
            bundle.putString(String.valueOf(3), mediaMetadata.getString("android.media.metadata.AUTHOR"));
        }
        if (mediaMetadata.containsKey("android.media.metadata.COMPILATION")) {
            bundle.putString(String.valueOf(15), mediaMetadata.getString("android.media.metadata.COMPILATION"));
        }
        if (mediaMetadata.containsKey("android.media.metadata.COMPOSER")) {
            bundle.putString(String.valueOf(4), mediaMetadata.getString("android.media.metadata.COMPOSER"));
        }
        if (mediaMetadata.containsKey("android.media.metadata.DATE")) {
            bundle.putString(String.valueOf(5), mediaMetadata.getString("android.media.metadata.DATE"));
        }
        if (mediaMetadata.containsKey("android.media.metadata.DISC_NUMBER")) {
            bundle.putLong(String.valueOf(14), mediaMetadata.getLong("android.media.metadata.DISC_NUMBER"));
        }
        if (mediaMetadata.containsKey("android.media.metadata.DURATION")) {
            bundle.putLong(String.valueOf(9), mediaMetadata.getLong("android.media.metadata.DURATION"));
        }
        if (mediaMetadata.containsKey("android.media.metadata.GENRE")) {
            bundle.putString(String.valueOf(6), mediaMetadata.getString("android.media.metadata.GENRE"));
        }
        if (mediaMetadata.containsKey("android.media.metadata.NUM_TRACKS")) {
            bundle.putLong(String.valueOf(10), mediaMetadata.getLong("android.media.metadata.NUM_TRACKS"));
        }
        if (mediaMetadata.containsKey("android.media.metadata.RATING")) {
            bundle.putParcelable(String.valueOf(101), mediaMetadata.getRating("android.media.metadata.RATING"));
        }
        if (mediaMetadata.containsKey("android.media.metadata.USER_RATING")) {
            bundle.putParcelable(String.valueOf((int) MediaMetadataEditor.RATING_KEY_BY_USER), mediaMetadata.getRating("android.media.metadata.USER_RATING"));
        }
        if (mediaMetadata.containsKey("android.media.metadata.TITLE")) {
            bundle.putString(String.valueOf(7), mediaMetadata.getString("android.media.metadata.TITLE"));
        }
        if (mediaMetadata.containsKey("android.media.metadata.TRACK_NUMBER")) {
            bundle.putLong(String.valueOf(0), mediaMetadata.getLong("android.media.metadata.TRACK_NUMBER"));
        }
        if (mediaMetadata.containsKey("android.media.metadata.WRITER")) {
            bundle.putString(String.valueOf(11), mediaMetadata.getString("android.media.metadata.WRITER"));
        }
        if (mediaMetadata.containsKey("android.media.metadata.YEAR")) {
            bundle.putString(String.valueOf(8), mediaMetadata.getString("android.media.metadata.YEAR"));
        }
        return bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (r0 > r12) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap scaleBitmapIfTooBig(android.graphics.Bitmap r10, int r11, int r12) {
        /*
            r0 = r10
            r16 = r0
            r0 = r10
            if (r0 == 0) goto L9f
            r0 = r10
            int r0 = r0.getWidth()
            r15 = r0
            r0 = r10
            int r0 = r0.getHeight()
            r14 = r0
            r0 = r15
            r1 = r11
            if (r0 > r1) goto L22
            r0 = r10
            r16 = r0
            r0 = r14
            r1 = r12
            if (r0 <= r1) goto L9f
        L22:
            r0 = r11
            float r0 = (float) r0
            r1 = r15
            float r1 = (float) r1
            float r0 = r0 / r1
            r1 = r12
            float r1 = (float) r1
            r2 = r14
            float r2 = (float) r2
            float r1 = r1 / r2
            float r0 = java.lang.Math.min(r0, r1)
            r13 = r0
            r0 = r15
            float r0 = (float) r0
            r1 = r13
            float r0 = r0 * r1
            int r0 = java.lang.Math.round(r0)
            r11 = r0
            r0 = r14
            float r0 = (float) r0
            r1 = r13
            float r0 = r0 * r1
            int r0 = java.lang.Math.round(r0)
            r12 = r0
            r0 = r10
            android.graphics.Bitmap$Config r0 = r0.getConfig()
            r17 = r0
            r0 = r17
            r16 = r0
            r0 = r17
            if (r0 != 0) goto L58
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            r16 = r0
        L58:
            r0 = r11
            r1 = r12
            r2 = r16
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2)
            r16 = r0
            android.graphics.Canvas r0 = new android.graphics.Canvas
            r1 = r0
            r2 = r16
            r1.<init>(r2)
            r17 = r0
            android.graphics.Paint r0 = new android.graphics.Paint
            r1 = r0
            r1.<init>()
            r18 = r0
            r0 = r18
            r1 = 1
            r0.setAntiAlias(r1)
            r0 = r18
            r1 = 1
            r0.setFilterBitmap(r1)
            r0 = r17
            r1 = r10
            r2 = 0
            android.graphics.RectF r3 = new android.graphics.RectF
            r4 = r3
            r5 = 0
            r6 = 0
            r7 = r16
            int r7 = r7.getWidth()
            float r7 = (float) r7
            r8 = r16
            int r8 = r8.getHeight()
            float r8 = (float) r8
            r4.<init>(r5, r6, r7, r8)
            r4 = r18
            r0.drawBitmap(r1, r2, r3, r4)
        L9f:
            r0 = r16
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.session.MediaSessionLegacyHelper.scaleBitmapIfTooBig(android.graphics.Bitmap, int, int):android.graphics.Bitmap");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendKeyEvent(PendingIntent pendingIntent, Context context, Intent intent) {
        try {
            pendingIntent.send(context, 0, intent);
        } catch (PendingIntent.CanceledException e) {
            Log.e(TAG, "Error sending media key down event:", e);
        }
    }

    public void addMediaButtonListener(PendingIntent pendingIntent, ComponentName componentName, Context context) {
        if (pendingIntent == null) {
            Log.w(TAG, "Pending intent was null, can't addMediaButtonListener.");
            return;
        }
        SessionHolder holder = getHolder(pendingIntent, true);
        if (holder != null) {
            if (holder.mMediaButtonListener != null && DEBUG) {
                Log.d(TAG, "addMediaButtonListener already added " + pendingIntent);
            }
            holder.mMediaButtonListener = new MediaButtonListener(pendingIntent, context);
            holder.mFlags |= 1;
            holder.mSession.setFlags(holder.mFlags);
            holder.mSession.setMediaButtonReceiver(pendingIntent);
            holder.update();
            if (DEBUG) {
                Log.d(TAG, "addMediaButtonListener added " + pendingIntent);
            }
        }
    }

    public void addRccListener(PendingIntent pendingIntent, MediaSession.Callback callback) {
        if (pendingIntent == null) {
            Log.w(TAG, "Pending intent was null, can't add rcc listener.");
            return;
        }
        SessionHolder holder = getHolder(pendingIntent, true);
        if (holder != null) {
            if (holder.mRccListener != null && holder.mRccListener == callback) {
                if (DEBUG) {
                    Log.d(TAG, "addRccListener listener already added.");
                    return;
                }
                return;
            }
            holder.mRccListener = callback;
            holder.mFlags |= 2;
            holder.mSession.setFlags(holder.mFlags);
            holder.update();
            if (DEBUG) {
                Log.d(TAG, "Added rcc listener for " + pendingIntent + ".");
            }
        }
    }

    public MediaSession getSession(PendingIntent pendingIntent) {
        SessionHolder sessionHolder = this.mSessions.get(pendingIntent);
        if (sessionHolder == null) {
            return null;
        }
        return sessionHolder.mSession;
    }

    public boolean isGlobalPriorityActive() {
        return this.mSessionManager.isGlobalPriorityActive();
    }

    public void removeMediaButtonListener(PendingIntent pendingIntent) {
        SessionHolder holder;
        if (pendingIntent == null || (holder = getHolder(pendingIntent, false)) == null || holder.mMediaButtonListener == null) {
            return;
        }
        holder.mFlags &= -2;
        holder.mSession.setFlags(holder.mFlags);
        holder.mMediaButtonListener = null;
        holder.update();
        if (DEBUG) {
            Log.d(TAG, "removeMediaButtonListener removed " + pendingIntent);
        }
    }

    public void removeRccListener(PendingIntent pendingIntent) {
        SessionHolder holder;
        if (pendingIntent == null || (holder = getHolder(pendingIntent, false)) == null || holder.mRccListener == null) {
            return;
        }
        holder.mRccListener = null;
        holder.mFlags &= -3;
        holder.mSession.setFlags(holder.mFlags);
        holder.update();
        if (DEBUG) {
            Log.d(TAG, "Removed rcc listener for " + pendingIntent + ".");
        }
    }

    public void sendAdjustVolumeBy(int i, int i2, int i3) {
        this.mSessionManager.dispatchAdjustVolume(i, i2, i3);
        if (DEBUG) {
            Log.d(TAG, "dispatched volume adjustment");
        }
    }

    public void sendMediaButtonEvent(KeyEvent keyEvent, boolean z) {
        if (keyEvent == null) {
            Log.w(TAG, "Tried to send a null key event. Ignoring.");
            return;
        }
        this.mSessionManager.dispatchMediaKeyEvent(keyEvent, z);
        if (DEBUG) {
            Log.d(TAG, "dispatched media key " + keyEvent);
        }
    }

    public void sendVolumeKeyEvent(KeyEvent keyEvent, boolean z) {
        if (keyEvent == null) {
            Log.w(TAG, "Tried to send a null key event. Ignoring.");
            return;
        }
        boolean z2 = keyEvent.getAction() == 0;
        boolean z3 = keyEvent.getAction() == 1;
        int i = 0;
        boolean z4 = false;
        switch (keyEvent.getKeyCode()) {
            case 24:
                i = 1;
                break;
            case 25:
                i = -1;
                break;
            case 164:
                z4 = true;
                break;
        }
        if (z2 || z3) {
            int i2 = z ? 512 : z3 ? 20 : 17;
            if (i != 0) {
                if (z3) {
                    i = 0;
                }
                this.mSessionManager.dispatchAdjustVolume(Integer.MIN_VALUE, i, i2);
            } else if (z4) {
                if (z2) {
                    this.mSessionManager.dispatchAdjustVolume(Integer.MIN_VALUE, -99, i2);
                }
                this.mSessionManager.dispatchAdjustVolume(Integer.MIN_VALUE, 0, i2);
            }
        }
    }
}
