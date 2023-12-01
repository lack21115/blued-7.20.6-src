package android.media;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Binder;
import android.os.RemoteException;
import android.provider.DrmStore;
import android.provider.MediaStore;
import android.util.Log;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/media/Ringtone.class */
public class Ringtone {
    private static final boolean LOGD = true;
    private static final String TAG = "Ringtone";
    private final boolean mAllowRemote;
    private AudioAttributes mAudioAttributes = new AudioAttributes.Builder().setUsage(6).setContentType(4).build();
    private final AudioManager mAudioManager;
    private final Context mContext;
    private MediaPlayer mLocalPlayer;
    private final IRingtonePlayer mRemotePlayer;
    private final Binder mRemoteToken;
    private String mTitle;
    private Uri mUri;
    private static final String[] MEDIA_COLUMNS = {"_id", "_data", "title"};
    private static final String[] DRM_COLUMNS = {"_id", "_data", "title"};

    public Ringtone(Context context, boolean z) {
        this.mContext = context;
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mAllowRemote = z;
        this.mRemotePlayer = z ? this.mAudioManager.getRingtonePlayer() : null;
        this.mRemoteToken = z ? new Binder() : null;
    }

    private void destroyLocalPlayer() {
        if (this.mLocalPlayer != null) {
            this.mLocalPlayer.reset();
            this.mLocalPlayer.release();
            this.mLocalPlayer = null;
        }
    }

    /* JADX WARN: Finally extract failed */
    private static String getTitle(Context context, Uri uri, boolean z) {
        Cursor cursor;
        String str;
        ContentResolver contentResolver = context.getContentResolver();
        String str2 = null;
        if (uri != null) {
            String authority = uri.getAuthority();
            if ("settings".equals(authority)) {
                str2 = null;
                if (z) {
                    Uri actualRingtoneUriBySubId = RingtoneManager.getDefaultType(uri) == 1 ? RingtoneManager.getActualRingtoneUriBySubId(context, RingtoneManager.getDefaultRingtoneSubIdByUri(uri)) : RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.getDefaultType(uri));
                    if (actualRingtoneUriBySubId == null) {
                        str = context.getString(17040779);
                        return str;
                    }
                    str2 = context.getString(17040780, getTitle(context, actualRingtoneUriBySubId, false));
                }
            } else {
                try {
                    if (DrmStore.AUTHORITY.equals(authority)) {
                        cursor = contentResolver.query(uri, DRM_COLUMNS, null, null, null);
                    } else {
                        cursor = null;
                        if (MediaStore.AUTHORITY.equals(authority)) {
                            cursor = contentResolver.query(uri, MEDIA_COLUMNS, null, null, null);
                        }
                    }
                } catch (SecurityException e) {
                    cursor = null;
                }
                if (cursor != null) {
                    try {
                        if (cursor.getCount() == 1) {
                            cursor.moveToFirst();
                            String string = cursor.getString(2);
                            str = string;
                            if (cursor != null) {
                                cursor.close();
                                return string;
                            }
                            return str;
                        }
                    } catch (Throwable th) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                String lastPathSegment = uri.getLastPathSegment();
                str2 = lastPathSegment;
                if (cursor != null) {
                    cursor.close();
                    str2 = lastPathSegment;
                }
            }
        }
        String str3 = str2;
        if (str2 == null) {
            String string2 = context.getString(17040783);
            str3 = string2;
            if (string2 == null) {
                str3 = "";
            }
        }
        return str3;
    }

    private boolean playFallbackRingtone() {
        if (this.mAudioManager.getStreamVolume(AudioAttributes.toLegacyStreamType(this.mAudioAttributes)) != 0) {
            int defaultRingtoneSubIdByUri = RingtoneManager.getDefaultRingtoneSubIdByUri(this.mUri);
            if (defaultRingtoneSubIdByUri == -1 || RingtoneManager.getActualRingtoneUriBySubId(this.mContext, defaultRingtoneSubIdByUri) == null) {
                Log.w(TAG, "not playing fallback for " + this.mUri);
                return false;
            }
            try {
                AssetFileDescriptor openRawResourceFd = this.mContext.getResources().openRawResourceFd(17825797);
                if (openRawResourceFd == null) {
                    Log.e(TAG, "Could not load fallback ringtone");
                    return false;
                }
                this.mLocalPlayer = new MediaPlayer();
                if (openRawResourceFd.getDeclaredLength() < 0) {
                    this.mLocalPlayer.setDataSource(openRawResourceFd.getFileDescriptor());
                } else {
                    this.mLocalPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getDeclaredLength());
                }
                this.mLocalPlayer.setAudioAttributes(this.mAudioAttributes);
                this.mLocalPlayer.prepare();
                this.mLocalPlayer.start();
                openRawResourceFd.close();
                return true;
            } catch (Resources.NotFoundException e) {
                Log.e(TAG, "Fallback ringtone does not exist");
                return false;
            } catch (IOException e2) {
                destroyLocalPlayer();
                Log.e(TAG, "Failed to open fallback ringtone");
                return false;
            }
        }
        return false;
    }

    public AudioAttributes getAudioAttributes() {
        return this.mAudioAttributes;
    }

    @Deprecated
    public int getStreamType() {
        return AudioAttributes.toLegacyStreamType(this.mAudioAttributes);
    }

    public String getTitle(Context context) {
        if (this.mTitle != null) {
            return this.mTitle;
        }
        String title = getTitle(context, this.mUri, true);
        this.mTitle = title;
        return title;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isPlaying() {
        if (this.mLocalPlayer != null) {
            return this.mLocalPlayer.isPlaying();
        }
        if (!this.mAllowRemote || this.mRemotePlayer == null) {
            Log.w(TAG, "Neither local nor remote playback available");
            return false;
        }
        try {
            return this.mRemotePlayer.isPlaying(this.mRemoteToken);
        } catch (RemoteException e) {
            Log.w(TAG, "Problem checking ringtone: " + e);
            return false;
        }
    }

    public void play() {
        if (this.mLocalPlayer != null) {
            if (this.mAudioManager.getStreamVolume(AudioAttributes.toLegacyStreamType(this.mAudioAttributes)) != 0) {
                this.mLocalPlayer.start();
            }
        } else if (!this.mAllowRemote || this.mRemotePlayer == null) {
            if (playFallbackRingtone()) {
                return;
            }
            Log.w(TAG, "Neither local nor remote playback available");
        } else {
            try {
                this.mRemotePlayer.play(this.mRemoteToken, this.mUri.getCanonicalUri(), this.mAudioAttributes);
            } catch (RemoteException e) {
                if (playFallbackRingtone()) {
                    return;
                }
                Log.w(TAG, "Problem playing ringtone: " + e);
            }
        }
    }

    public void setAudioAttributes(AudioAttributes audioAttributes) throws IllegalArgumentException {
        if (audioAttributes == null) {
            throw new IllegalArgumentException("Invalid null AudioAttributes for Ringtone");
        }
        this.mAudioAttributes = audioAttributes;
        setUri(this.mUri);
    }

    @Deprecated
    public void setStreamType(int i) {
        setAudioAttributes(new AudioAttributes.Builder().setInternalLegacyStreamType(i).build());
    }

    void setTitle(String str) {
        this.mTitle = str;
    }

    public void setUri(Uri uri) {
        destroyLocalPlayer();
        this.mUri = uri;
        if (this.mUri == null) {
            return;
        }
        this.mLocalPlayer = new MediaPlayer();
        try {
            this.mLocalPlayer.setDataSource(this.mContext, this.mUri);
            this.mLocalPlayer.setAudioAttributes(this.mAudioAttributes);
            this.mLocalPlayer.prepare();
        } catch (IOException | SecurityException e) {
            destroyLocalPlayer();
            if (!this.mAllowRemote) {
                Log.w(TAG, "Remote playback not allowed: " + e);
            }
        }
        if (this.mLocalPlayer != null) {
            Log.d(TAG, "Successfully created local player");
        } else {
            Log.d(TAG, "Problem opening; delegating to remote player");
        }
    }

    public void setVolume(float f) {
        if (this.mLocalPlayer != null) {
            this.mLocalPlayer.setVolume(f);
        } else if (!this.mAllowRemote || this.mRemotePlayer == null) {
        } else {
            try {
                this.mRemotePlayer.setVolume(this.mRemoteToken, f);
            } catch (RemoteException e) {
                Log.w(TAG, "Problem setting ringtone volume: " + e);
            }
        }
    }

    public void stop() {
        if (this.mLocalPlayer != null) {
            destroyLocalPlayer();
        } else if (!this.mAllowRemote || this.mRemotePlayer == null) {
        } else {
            try {
                this.mRemotePlayer.stop(this.mRemoteToken);
            } catch (RemoteException e) {
                Log.w(TAG, "Problem stopping ringtone: " + e);
            }
        }
    }
}
