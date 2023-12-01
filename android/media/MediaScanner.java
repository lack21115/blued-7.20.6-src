package android.media;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.IContentProvider;
import android.database.Cursor;
import android.database.SQLException;
import android.drm.DrmManagerClient;
import android.graphics.BitmapFactory;
import android.media.MediaFile;
import android.mtp.MtpConstants;
import android.net.Uri;
import android.os.Environment;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.provider.MediaStore;
import android.provider.Settings;
import android.sax.ElementListener;
import android.sax.RootElement;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.anythink.expressad.exoplayer.k.o;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.cdo.oaps.ad.OapsKey;
import com.google.common.net.HttpHeaders;
import com.kuaishou.weapon.p0.bh;
import com.oplus.quickgame.sdk.hall.Constant;
import com.tencent.connect.common.Constants;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

/* loaded from: source-9557208-dex2jar.jar:android/media/MediaScanner.class */
public class MediaScanner {
    private static final String ALARMS_DIR = "/alarms/";
    private static final int DATE_MODIFIED_PLAYLISTS_COLUMN_INDEX = 2;
    private static final Pattern DATE_YEAR_DETECT_PATTERN;
    private static final String DEFAULT_RINGTONE_PROPERTY_PREFIX = "ro.config.";
    private static final int DEFAULT_SIM_INDEX = 0;
    private static final boolean ENABLE_BULK_INSERTS = true;
    private static final int FILES_PRESCAN_DATE_MODIFIED_COLUMN_INDEX = 3;
    private static final int FILES_PRESCAN_FORMAT_COLUMN_INDEX = 2;
    private static final int FILES_PRESCAN_ID_COLUMN_INDEX = 0;
    private static final int FILES_PRESCAN_PATH_COLUMN_INDEX = 1;
    private static final String[] FILES_PRESCAN_PROJECTION;
    private static final String[] ID3_GENRES;
    private static final int ID_PLAYLISTS_COLUMN_INDEX = 0;
    private static final String[] ID_PROJECTION;
    private static final String MUSIC_DIR = "/music/";
    private static final String NOTIFICATIONS_DIR = "/notifications/";
    private static final int PATH_PLAYLISTS_COLUMN_INDEX = 1;
    private static final String[] PLAYLIST_MEMBERS_PROJECTION;
    private static final String PODCAST_DIR = "/podcasts/";
    private static final String RINGTONES_DIR = "/ringtones/";
    private static final String TAG = "MediaScanner";
    private static HashMap<String, String> mMediaPaths;
    private static HashMap<String, String> mNoMediaPaths;
    private Uri mAudioUri;
    private boolean mCaseInsensitivePaths;
    private Context mContext;
    private String mDefaultAlarmAlertFilename;
    private boolean mDefaultAlarmSet;
    private String mDefaultNotificationFilename;
    private boolean mDefaultNotificationSet;
    private String[] mDefaultRingtoneFilenames;
    private boolean[] mDefaultRingtonesSet;
    private final boolean mExternalIsEmulated;
    private final String mExternalStoragePath;
    private Uri mFilesUri;
    private Uri mFilesUriNoNotify;
    private Uri mImagesUri;
    private MediaInserter mMediaInserter;
    private IContentProvider mMediaProvider;
    private int mMtpObjectHandle;
    private long mNativeContext;
    private int mOriginalCount;
    private String mPackageName;
    private ArrayList<FileEntry> mPlayLists;
    private Uri mPlaylistsUri;
    private boolean mProcessGenres;
    private boolean mProcessPlaylists;
    private Uri mThumbsUri;
    private Uri mVideoUri;
    private boolean mWasEmptyPriorToScan = false;
    private final BitmapFactory.Options mBitmapOptions = new BitmapFactory.Options();
    private ArrayList<PlaylistEntry> mPlaylistEntries = new ArrayList<>();
    private DrmManagerClient mDrmManagerClient = null;
    private final MyMediaScannerClient mClient = new MyMediaScannerClient();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaScanner$FileEntry.class */
    public static class FileEntry {
        int mFormat;
        long mLastModified;
        boolean mLastModifiedChanged = false;
        String mPath;
        long mRowId;

        FileEntry(long j, String str, long j2, int i) {
            this.mRowId = j;
            this.mPath = str;
            this.mLastModified = j2;
            this.mFormat = i;
        }

        public String toString() {
            return this.mPath + " mRowId: " + this.mRowId;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaScanner$MediaBulkDeleter.class */
    public static class MediaBulkDeleter {
        final Uri mBaseUri;
        final String mPackageName;
        final IContentProvider mProvider;
        StringBuilder whereClause = new StringBuilder();
        ArrayList<String> whereArgs = new ArrayList<>(100);

        public MediaBulkDeleter(IContentProvider iContentProvider, String str, Uri uri) {
            this.mProvider = iContentProvider;
            this.mPackageName = str;
            this.mBaseUri = uri;
        }

        public void delete(long j) throws RemoteException {
            if (this.whereClause.length() != 0) {
                this.whereClause.append(",");
            }
            this.whereClause.append("?");
            this.whereArgs.add("" + j);
            if (this.whereArgs.size() > 100) {
                flush();
            }
        }

        public void flush() throws RemoteException {
            int size = this.whereArgs.size();
            if (size > 0) {
                this.mProvider.delete(this.mPackageName, this.mBaseUri, "_id IN (" + this.whereClause.toString() + ")", (String[]) this.whereArgs.toArray(new String[size]));
                this.whereClause.setLength(0);
                this.whereArgs.clear();
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaScanner$MyMediaScannerClient.class */
    private class MyMediaScannerClient implements MediaScannerClient {
        private String mAlbum;
        private String mAlbumArtist;
        private String mArtist;
        private int mCompilation;
        private String mComposer;
        private int mDuration;
        private long mFileSize;
        private int mFileType;
        private String mGenre;
        private int mHeight;
        private boolean mIsDrm;
        private long mLastModified;
        private String mMimeType;
        private boolean mNoMedia;
        private String mPath;
        private String mTitle;
        private int mTrack;
        private int mWidth;
        private String mWriter;
        private int mYear;

        private MyMediaScannerClient() {
        }

        private boolean convertGenreCode(String str, String str2) {
            String genreName = getGenreName(str);
            if (genreName.equals(str2)) {
                return true;
            }
            Log.d(MediaScanner.TAG, "'" + str + "' -> '" + genreName + "', expected '" + str2 + "'");
            return false;
        }

        private boolean doesPathHaveFilename(String str, String str2) {
            int lastIndexOf = str.lastIndexOf(File.separatorChar) + 1;
            int length = str2.length();
            boolean z = false;
            if (str.regionMatches(lastIndexOf, str2, 0, length)) {
                z = false;
                if (lastIndexOf + length == str.length()) {
                    z = true;
                }
            }
            return z;
        }

        /* JADX WARN: Code restructure failed: missing block: B:123:0x03c5, code lost:
            r14 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:0x040b, code lost:
            if (doesPathHaveFilename(r8.mPath, r7.this$0.mDefaultAlarmAlertFilename) != false) goto L88;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x01c8, code lost:
            if (doesPathHaveFilename(r8.mPath, r7.this$0.mDefaultNotificationFilename) != false) goto L63;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private android.net.Uri endFile(android.media.MediaScanner.FileEntry r8, boolean r9, boolean r10, boolean r11, boolean r12, boolean r13) throws android.os.RemoteException {
            /*
                Method dump skipped, instructions count: 1398
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.media.MediaScanner.MyMediaScannerClient.endFile(android.media.MediaScanner$FileEntry, boolean, boolean, boolean, boolean, boolean):android.net.Uri");
        }

        private int getFileTypeFromDrm(String str) {
            if (MediaScanner.this.isDrmEnabled()) {
                if (MediaScanner.this.mDrmManagerClient == null) {
                    MediaScanner.this.mDrmManagerClient = new DrmManagerClient(MediaScanner.this.mContext);
                }
                String replace = str.replace("/storage/emulated/0", "/storage/emulated/legacy");
                if (MediaScanner.this.mDrmManagerClient.canHandle(replace, (String) null)) {
                    this.mIsDrm = true;
                    String originalMimeType = MediaScanner.this.mDrmManagerClient.getOriginalMimeType(replace);
                    if (originalMimeType != null) {
                        this.mMimeType = originalMimeType;
                        return MediaFile.getFileTypeForMimeType(originalMimeType);
                    }
                    return 0;
                }
                return 0;
            }
            return 0;
        }

        private int parseSubstring(String str, int i, int i2) {
            int length = str.length();
            if (i == length) {
                return i2;
            }
            int i3 = i + 1;
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i2;
            }
            int i4 = charAt - '0';
            int i5 = i3;
            while (true) {
                int i6 = i5;
                if (i6 >= length) {
                    return i4;
                }
                char charAt2 = str.charAt(i6);
                if (charAt2 < '0' || charAt2 > '9') {
                    break;
                }
                i4 = (i4 * 10) + (charAt2 - '0');
                i5 = i6 + 1;
            }
            return i4;
        }

        private void processImageFile(String str) {
            try {
                MediaScanner.this.mBitmapOptions.outWidth = 0;
                MediaScanner.this.mBitmapOptions.outHeight = 0;
                BitmapFactory.decodeFile(str, MediaScanner.this.mBitmapOptions);
                this.mWidth = MediaScanner.this.mBitmapOptions.outWidth;
                this.mHeight = MediaScanner.this.mBitmapOptions.outHeight;
            } catch (Throwable th) {
            }
        }

        private boolean ringtoneDefaultsSet() {
            boolean[] zArr = MediaScanner.this.mDefaultRingtonesSet;
            int length = zArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return true;
                }
                if (!zArr[i2]) {
                    return false;
                }
                i = i2 + 1;
            }
        }

        private void setSettingIfNotSet(String str, Uri uri, long j) {
            if (TextUtils.isEmpty(Settings.System.getString(MediaScanner.this.mContext.getContentResolver(), str))) {
                Settings.System.putString(MediaScanner.this.mContext.getContentResolver(), str, ContentUris.withAppendedId(uri, j).toString());
            }
        }

        private void testGenreNameConverter() {
            convertGenreCode("2", "Country");
            convertGenreCode("(2)", "Country");
            convertGenreCode("(2", "(2");
            convertGenreCode("2 Foo", "Country");
            convertGenreCode("(2) Foo", "Country");
            convertGenreCode("(2 Foo", "(2 Foo");
            convertGenreCode("2Foo", "2Foo");
            convertGenreCode("(2)Foo", "Country");
            convertGenreCode("200 Foo", "Foo");
            convertGenreCode("(200) Foo", "Foo");
            convertGenreCode("200Foo", "200Foo");
            convertGenreCode("(200)Foo", "Foo");
            convertGenreCode("200)Foo", "200)Foo");
            convertGenreCode("200) Foo", "200) Foo");
        }

        private ContentValues toValues() {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", this.mPath);
            contentValues.put("title", this.mTitle);
            contentValues.put("date_modified", Long.valueOf(this.mLastModified));
            contentValues.put("_size", Long.valueOf(this.mFileSize));
            contentValues.put("mime_type", this.mMimeType);
            contentValues.put(MediaStore.MediaColumns.IS_DRM, Boolean.valueOf(this.mIsDrm));
            String str = null;
            if (this.mWidth > 0) {
                str = null;
                if (this.mHeight > 0) {
                    contentValues.put("width", Integer.valueOf(this.mWidth));
                    contentValues.put("height", Integer.valueOf(this.mHeight));
                    str = this.mWidth + "x" + this.mHeight;
                }
            }
            if (!this.mNoMedia) {
                if (MediaFile.isVideoFileType(this.mFileType)) {
                    contentValues.put("artist", (this.mArtist == null || this.mArtist.length() <= 0) ? "<unknown>" : this.mArtist);
                    contentValues.put("album", (this.mAlbum == null || this.mAlbum.length() <= 0) ? "<unknown>" : this.mAlbum);
                    contentValues.put("duration", Integer.valueOf(this.mDuration));
                    if (str != null) {
                        contentValues.put("resolution", str);
                    }
                } else if (!MediaFile.isImageFileType(this.mFileType) && MediaFile.isAudioFileType(this.mFileType)) {
                    contentValues.put("artist", (this.mArtist == null || this.mArtist.length() <= 0) ? "<unknown>" : this.mArtist);
                    contentValues.put(MediaStore.Audio.AudioColumns.ALBUM_ARTIST, (this.mAlbumArtist == null || this.mAlbumArtist.length() <= 0) ? null : this.mAlbumArtist);
                    contentValues.put("album", (this.mAlbum == null || this.mAlbum.length() <= 0) ? "<unknown>" : this.mAlbum);
                    contentValues.put(MediaStore.Audio.AudioColumns.COMPOSER, this.mComposer);
                    contentValues.put(MediaStore.Audio.AudioColumns.GENRE, this.mGenre);
                    if (this.mYear != 0) {
                        contentValues.put(MediaStore.Audio.AudioColumns.YEAR, Integer.valueOf(this.mYear));
                    }
                    contentValues.put(MediaStore.Audio.AudioColumns.TRACK, Integer.valueOf(this.mTrack));
                    contentValues.put("duration", Integer.valueOf(this.mDuration));
                    contentValues.put(MediaStore.Audio.AudioColumns.COMPILATION, Integer.valueOf(this.mCompilation));
                    return contentValues;
                }
            }
            return contentValues;
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x00c6, code lost:
            if (r18 != false) goto L48;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.media.MediaScanner.FileEntry beginFile(java.lang.String r10, java.lang.String r11, long r12, long r14, boolean r16, boolean r17) {
            /*
                Method dump skipped, instructions count: 376
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.media.MediaScanner.MyMediaScannerClient.beginFile(java.lang.String, java.lang.String, long, long, boolean, boolean):android.media.MediaScanner$FileEntry");
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x00cf, code lost:
            if (r0 != false) goto L62;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.net.Uri doScanFile(java.lang.String r11, java.lang.String r12, long r13, long r15, boolean r17, boolean r18, boolean r19) {
            /*
                Method dump skipped, instructions count: 403
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.media.MediaScanner.MyMediaScannerClient.doScanFile(java.lang.String, java.lang.String, long, long, boolean, boolean, boolean):android.net.Uri");
        }

        public String getGenreName(String str) {
            int i;
            String str2 = null;
            if (str != null) {
                int length = str.length();
                if (length > 0) {
                    boolean z = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    int i2 = 0;
                    while (true) {
                        i = i2;
                        if (i >= length) {
                            break;
                        }
                        char charAt = str.charAt(i);
                        if (i != 0 || charAt != '(') {
                            if (!Character.isDigit(charAt)) {
                                break;
                            }
                            stringBuffer.append(charAt);
                        } else {
                            z = true;
                        }
                        i2 = i + 1;
                    }
                    char charAt2 = i < length ? str.charAt(i) : ' ';
                    if ((z && charAt2 == ')') || (!z && Character.isWhitespace(charAt2))) {
                        try {
                            short parseShort = Short.parseShort(stringBuffer.toString());
                            if (parseShort >= 0) {
                                if (parseShort < MediaScanner.ID3_GENRES.length && MediaScanner.ID3_GENRES[parseShort] != null) {
                                    return MediaScanner.ID3_GENRES[parseShort];
                                }
                                if (parseShort != 255) {
                                    if (parseShort >= 255 || i + 1 >= length) {
                                        return stringBuffer.toString();
                                    }
                                    int i3 = i;
                                    if (z) {
                                        i3 = i;
                                        if (charAt2 == ')') {
                                            i3 = i + 1;
                                        }
                                    }
                                    String trim = str.substring(i3).trim();
                                    str2 = trim;
                                    if (trim.length() == 0) {
                                    }
                                }
                            }
                        } catch (NumberFormatException e) {
                        }
                    }
                }
                return str;
            }
            return str2;
        }

        @Override // android.media.MediaScannerClient
        public void handleStringTag(String str, String str2) {
            boolean z = true;
            if (str.equalsIgnoreCase("title") || str.startsWith("title;")) {
                this.mTitle = str2;
            } else if (str.equalsIgnoreCase("artist") || str.startsWith("artist;")) {
                this.mArtist = str2.trim();
            } else if (str.equalsIgnoreCase("albumartist") || str.startsWith("albumartist;") || str.equalsIgnoreCase("band") || str.startsWith("band;")) {
                this.mAlbumArtist = str2.trim();
            } else if (str.equalsIgnoreCase("album") || str.startsWith("album;")) {
                this.mAlbum = str2.trim();
            } else if (str.equalsIgnoreCase(MediaStore.Audio.AudioColumns.COMPOSER) || str.startsWith("composer;")) {
                this.mComposer = str2.trim();
            } else if (MediaScanner.this.mProcessGenres && (str.equalsIgnoreCase(MediaStore.Audio.AudioColumns.GENRE) || str.startsWith("genre;"))) {
                this.mGenre = getGenreName(str2);
            } else if (str.equalsIgnoreCase(MediaStore.Audio.AudioColumns.YEAR) || str.startsWith("year;")) {
                this.mYear = parseSubstring(str2, 0, 0);
            } else if ((this.mYear == 0 && str.equalsIgnoreCase("date")) || str.startsWith("date;")) {
                Matcher matcher = MediaScanner.DATE_YEAR_DETECT_PATTERN.matcher(str2);
                if (matcher.find()) {
                    this.mYear = parseSubstring(matcher.group(1), 0, 0);
                }
            } else if (str.equalsIgnoreCase("tracknumber") || str.startsWith("tracknumber;")) {
                this.mTrack = ((this.mTrack / 1000) * 1000) + parseSubstring(str2, 0, 0);
            } else if (str.equalsIgnoreCase("discnumber") || str.equals("set") || str.startsWith("set;")) {
                this.mTrack = (parseSubstring(str2, 0, 0) * 1000) + (this.mTrack % 1000);
            } else if (str.equalsIgnoreCase("duration")) {
                this.mDuration = parseSubstring(str2, 0, 0);
            } else if (str.equalsIgnoreCase("writer") || str.startsWith("writer;")) {
                this.mWriter = str2.trim();
            } else if (str.equalsIgnoreCase(MediaStore.Audio.AudioColumns.COMPILATION)) {
                this.mCompilation = parseSubstring(str2, 0, 0);
            } else if (str.equalsIgnoreCase("isdrm")) {
                if (parseSubstring(str2, 0, 0) != 1) {
                    z = false;
                }
                this.mIsDrm = z;
            } else if (str.equalsIgnoreCase("width")) {
                this.mWidth = parseSubstring(str2, 0, 0);
            } else if (str.equalsIgnoreCase("height")) {
                this.mHeight = parseSubstring(str2, 0, 0);
            }
        }

        @Override // android.media.MediaScannerClient
        public void scanFile(String str, long j, long j2, boolean z, boolean z2) {
            doScanFile(str, null, j, j2, z, false, z2);
        }

        @Override // android.media.MediaScannerClient
        public void setMimeType(String str) {
            if (o.q.equals(this.mMimeType) && str.startsWith("video")) {
                return;
            }
            this.mMimeType = str;
            this.mFileType = MediaFile.getFileTypeForMimeType(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaScanner$PlaylistEntry.class */
    public static class PlaylistEntry {
        long bestmatchid;
        int bestmatchlevel;
        String path;

        private PlaylistEntry() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaScanner$WplHandler.class */
    public class WplHandler implements ElementListener {
        final ContentHandler handler;
        String playListDirectory;

        public WplHandler(String str, Uri uri, Cursor cursor) {
            this.playListDirectory = str;
            RootElement rootElement = new RootElement("smil");
            rootElement.getChild(TtmlUtils.TAG_BODY).getChild("seq").getChild(MediaStore.AUTHORITY).setElementListener(this);
            this.handler = rootElement.getContentHandler();
        }

        @Override // android.sax.EndElementListener
        public void end() {
        }

        ContentHandler getContentHandler() {
            return this.handler;
        }

        @Override // android.sax.StartElementListener
        public void start(Attributes attributes) {
            String value = attributes.getValue("", OapsKey.KEY_SRC);
            if (value != null) {
                MediaScanner.this.cachePlaylistEntry(value, this.playListDirectory);
            }
        }
    }

    static {
        System.loadLibrary("media_jni");
        native_init();
        FILES_PRESCAN_PROJECTION = new String[]{"_id", "_data", "format", "date_modified"};
        ID_PROJECTION = new String[]{"_id"};
        PLAYLIST_MEMBERS_PROJECTION = new String[]{MediaStore.Audio.Playlists.Members.PLAYLIST_ID};
        ID3_GENRES = new String[]{"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "Britpop", null, "Polsk Punk", "Beat", "Christian Gangsta", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "JPop", "Synthpop"};
        DATE_YEAR_DETECT_PATTERN = Pattern.compile("^(\\d{4})(-\\d{2})?$");
        mNoMediaPaths = new HashMap<>();
        mMediaPaths = new HashMap<>();
    }

    public MediaScanner(Context context) {
        native_setup();
        this.mContext = context;
        this.mPackageName = context.getPackageName();
        this.mBitmapOptions.inSampleSize = 1;
        this.mBitmapOptions.inJustDecodeBounds = true;
        setDefaultRingtoneFileNames();
        this.mExternalStoragePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.mExternalIsEmulated = Environment.isExternalStorageEmulated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007e, code lost:
        if (r10.charAt(2) == '\\') goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void cachePlaylistEntry(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = 0
            r9 = r0
            android.media.MediaScanner$PlaylistEntry r0 = new android.media.MediaScanner$PlaylistEntry
            r1 = r0
            r2 = 0
            r1.<init>()
            r11 = r0
            r0 = r5
            int r0 = r0.length()
            r8 = r0
        L13:
            r0 = r8
            if (r0 <= 0) goto L2f
            r0 = r5
            r1 = r8
            r2 = 1
            int r1 = r1 - r2
            char r0 = r0.charAt(r1)
            boolean r0 = java.lang.Character.isWhitespace(r0)
            if (r0 == 0) goto L2f
            r0 = r8
            r1 = 1
            int r0 = r0 - r1
            r8 = r0
            goto L13
        L2f:
            r0 = r8
            r1 = 3
            if (r0 >= r1) goto L36
            return
        L36:
            r0 = r5
            r10 = r0
            r0 = r8
            r1 = r5
            int r1 = r1.length()
            if (r0 >= r1) goto L4b
            r0 = r5
            r1 = 0
            r2 = r8
            java.lang.String r0 = r0.substring(r1, r2)
            r10 = r0
        L4b:
            r0 = r10
            r1 = 0
            char r0 = r0.charAt(r1)
            r7 = r0
            r0 = r7
            r1 = 47
            if (r0 == r1) goto L81
            r0 = r9
            r8 = r0
            r0 = r7
            boolean r0 = java.lang.Character.isLetter(r0)
            if (r0 == 0) goto L84
            r0 = r9
            r8 = r0
            r0 = r10
            r1 = 1
            char r0 = r0.charAt(r1)
            r1 = 58
            if (r0 != r1) goto L84
            r0 = r9
            r8 = r0
            r0 = r10
            r1 = 2
            char r0 = r0.charAt(r1)
            r1 = 92
            if (r0 != r1) goto L84
        L81:
            r0 = 1
            r8 = r0
        L84:
            r0 = r10
            r5 = r0
            r0 = r8
            if (r0 != 0) goto La0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r10
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5 = r0
        La0:
            r0 = r11
            r1 = r5
            r0.path = r1
            r0 = r4
            java.util.ArrayList<android.media.MediaScanner$PlaylistEntry> r0 = r0.mPlaylistEntries
            r1 = r11
            boolean r0 = r0.add(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.MediaScanner.cachePlaylistEntry(java.lang.String, java.lang.String):void");
    }

    public static void clearMediaPathCache(boolean z, boolean z2) {
        synchronized (MediaScanner.class) {
            if (z) {
                try {
                    mMediaPaths.clear();
                } finally {
                }
            }
            if (z2) {
                mNoMediaPaths.clear();
            }
        }
    }

    private boolean inScanDirectory(String str, String[] strArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private void initialize(String str) {
        this.mMediaProvider = this.mContext.getContentResolver().acquireProvider(MediaStore.AUTHORITY);
        this.mAudioUri = MediaStore.Audio.Media.getContentUri(str);
        this.mVideoUri = MediaStore.Video.Media.getContentUri(str);
        this.mImagesUri = MediaStore.Images.Media.getContentUri(str);
        this.mThumbsUri = MediaStore.Images.Thumbnails.getContentUri(str);
        this.mFilesUri = MediaStore.Files.getContentUri(str);
        this.mFilesUriNoNotify = this.mFilesUri.buildUpon().appendQueryParameter("nonotify", "1").build();
        if (str.equals(UMModuleRegister.INNER)) {
            return;
        }
        this.mProcessPlaylists = true;
        this.mProcessGenres = true;
        this.mPlaylistsUri = MediaStore.Audio.Playlists.getContentUri(str);
        this.mCaseInsensitivePaths = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDrmEnabled() {
        String str = SystemProperties.get("drm.service.enabled");
        return str != null && str.equals("true");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0097, code lost:
        if (r7.regionMatches(true, r0 + 1, "AlbumArtSmall", 0, 13) == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isNoMediaFile(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 182
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.MediaScanner.isNoMediaFile(java.lang.String):boolean");
    }

    public static boolean isNoMediaPath(String str) {
        if (str == null) {
            return false;
        }
        if (str.indexOf(bh.j) >= 0) {
            return true;
        }
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf > 0) {
            String substring = str.substring(0, lastIndexOf);
            synchronized (MediaScanner.class) {
                try {
                    if (mNoMediaPaths.containsKey(substring)) {
                        return true;
                    }
                    if (!mMediaPaths.containsKey(substring)) {
                        int i = 1;
                        while (true) {
                            int i2 = i;
                            if (i2 < 0) {
                                mMediaPaths.put(substring, "");
                                break;
                            }
                            int indexOf = str.indexOf(47, i2);
                            int i3 = indexOf;
                            if (indexOf > i2) {
                                int i4 = indexOf + 1;
                                i3 = i4;
                                if (new File(str.substring(0, i4) + MediaStore.MEDIA_IGNORE_FILENAME).exists()) {
                                    mNoMediaPaths.put(substring, "");
                                    return true;
                                }
                            }
                            i = i3;
                        }
                    }
                    return isNoMediaFile(str);
                } finally {
                }
            }
        }
        return false;
    }

    private boolean matchEntries(long j, String str) {
        int size = this.mPlaylistEntries.size();
        boolean z = true;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return z;
            }
            PlaylistEntry playlistEntry = this.mPlaylistEntries.get(i2);
            if (playlistEntry.bestmatchlevel != Integer.MAX_VALUE) {
                if (str.equalsIgnoreCase(playlistEntry.path)) {
                    playlistEntry.bestmatchid = j;
                    playlistEntry.bestmatchlevel = Integer.MAX_VALUE;
                    z = false;
                } else {
                    int matchPaths = matchPaths(str, playlistEntry.path);
                    z = false;
                    if (matchPaths > playlistEntry.bestmatchlevel) {
                        playlistEntry.bestmatchid = j;
                        playlistEntry.bestmatchlevel = matchPaths;
                        z = false;
                    }
                }
            }
            i = i2 + 1;
        }
    }

    private int matchPaths(String str, String str2) {
        int i = 0;
        int length = str.length();
        int length2 = str2.length();
        while (true) {
            int i2 = length2;
            if (length <= 0 || i2 <= 0) {
                break;
            }
            int lastIndexOf = str.lastIndexOf(47, length - 1);
            int lastIndexOf2 = str2.lastIndexOf(47, i2 - 1);
            int lastIndexOf3 = str.lastIndexOf(92, length - 1);
            int lastIndexOf4 = str2.lastIndexOf(92, i2 - 1);
            if (lastIndexOf <= lastIndexOf3) {
                lastIndexOf = lastIndexOf3;
            }
            if (lastIndexOf2 <= lastIndexOf4) {
                lastIndexOf2 = lastIndexOf4;
            }
            int i3 = lastIndexOf < 0 ? 0 : lastIndexOf + 1;
            int i4 = lastIndexOf2 < 0 ? 0 : lastIndexOf2 + 1;
            int i5 = length - i3;
            if (i2 - i4 != i5 || !str.regionMatches(true, i3, str2, i4, i5)) {
                break;
            }
            i++;
            length = i3 - 1;
            length2 = i4 - 1;
        }
        return i;
    }

    private final native void native_finalize();

    private static final native void native_init();

    private final native void native_setup();

    private void postscan(String[] strArr) throws RemoteException {
        if (this.mProcessPlaylists) {
            processPlayLists();
        }
        if (this.mOriginalCount == 0 && this.mImagesUri.equals(MediaStore.Images.Media.getContentUri(Constant.Param.KEY_RPK_EXTERNAL))) {
            pruneDeadThumbnailFiles();
        }
        this.mPlayLists = null;
        this.mMediaProvider = null;
    }

    private void prescan(String str, boolean z) throws RemoteException {
        String str2;
        String[] strArr;
        Cursor cursor = null;
        if (this.mPlayLists == null) {
            this.mPlayLists = new ArrayList<>();
        } else {
            this.mPlayLists.clear();
        }
        if (str != null) {
            str2 = "_id>? AND _data=?";
            strArr = new String[]{"", str};
        } else {
            str2 = "_id>?";
            strArr = new String[]{""};
        }
        Uri.Builder buildUpon = this.mFilesUri.buildUpon();
        buildUpon.appendQueryParameter(MediaStore.PARAM_DELETE_DATA, "false");
        MediaBulkDeleter mediaBulkDeleter = new MediaBulkDeleter(this.mMediaProvider, this.mPackageName, buildUpon.build());
        if (z) {
            long j = Long.MIN_VALUE;
            Cursor cursor2 = null;
            try {
                Uri build = this.mFilesUri.buildUpon().appendQueryParameter("limit", Constants.DEFAULT_UIN).build();
                this.mWasEmptyPriorToScan = true;
                Cursor cursor3 = null;
                while (true) {
                    cursor2 = cursor3;
                    strArr[0] = "" + j;
                    Cursor cursor4 = cursor3;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    Cursor query = this.mMediaProvider.query(this.mPackageName, build, FILES_PRESCAN_PROJECTION, str2, strArr, "_id", null);
                    if (query != null) {
                        cursor = query;
                        if (query.getCount() == 0) {
                            break;
                        }
                        this.mWasEmptyPriorToScan = false;
                        while (true) {
                            cursor3 = query;
                            if (query.moveToNext()) {
                                long j2 = query.getLong(0);
                                String string = query.getString(1);
                                int i = query.getInt(2);
                                query.getLong(3);
                                j = j2;
                                if (string != null) {
                                    j = j2;
                                    if (string.startsWith(BridgeUtil.SPLIT_MARK)) {
                                        boolean z2 = false;
                                        try {
                                            z2 = Os.access(string, OsConstants.F_OK);
                                        } catch (ErrnoException e) {
                                        }
                                        j = j2;
                                        if (!z2) {
                                            j = j2;
                                            if (!MtpConstants.isAbstractObject(i)) {
                                                MediaFile.MediaFileType fileType = MediaFile.getFileType(string);
                                                j = j2;
                                                if (!MediaFile.isPlayListFileType(fileType == null ? 0 : fileType.fileType)) {
                                                    mediaBulkDeleter.delete(j2);
                                                    j = j2;
                                                    if (string.toLowerCase(Locale.US).endsWith("/.nomedia")) {
                                                        mediaBulkDeleter.flush();
                                                        this.mMediaProvider.call(this.mPackageName, MediaStore.UNHIDE_CALL, new File(string).getParent(), null);
                                                        j = j2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        cursor = query;
                        break;
                    }
                }
            } catch (Throwable th) {
                if (cursor2 != null) {
                    cursor2.close();
                }
                mediaBulkDeleter.flush();
                throw th;
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        mediaBulkDeleter.flush();
        this.mOriginalCount = 0;
        Cursor query2 = this.mMediaProvider.query(this.mPackageName, this.mImagesUri, ID_PROJECTION, null, null, null, null);
        if (query2 != null) {
            this.mOriginalCount = query2.getCount();
            query2.close();
        }
    }

    private void processCachedPlaylist(Cursor cursor, ContentValues contentValues, Uri uri) {
        cursor.moveToPosition(-1);
        while (cursor.moveToNext() && !matchEntries(cursor.getLong(0), cursor.getString(1))) {
        }
        int size = this.mPlaylistEntries.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            PlaylistEntry playlistEntry = this.mPlaylistEntries.get(i2);
            int i3 = i;
            if (playlistEntry.bestmatchlevel > 0) {
                try {
                    contentValues.clear();
                    contentValues.put("play_order", Integer.valueOf(i));
                    contentValues.put("audio_id", Long.valueOf(playlistEntry.bestmatchid));
                    this.mMediaProvider.insert(this.mPackageName, uri, contentValues);
                    i3 = i + 1;
                } catch (RemoteException e) {
                    Log.e(TAG, "RemoteException in MediaScanner.processCachedPlaylist()", e);
                    return;
                }
            }
            i2++;
            i = i3;
        }
        this.mPlaylistEntries.clear();
    }

    private native void processDirectory(String str, MediaScannerClient mediaScannerClient);

    /* JADX INFO: Access modifiers changed from: private */
    public native void processFile(String str, String str2, MediaScannerClient mediaScannerClient);

    private void processM3uPlayList(String str, String str2, Uri uri, ContentValues contentValues, Cursor cursor) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                File file = new File(str);
                bufferedReader = null;
                if (file.exists()) {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)), 8192);
                    try {
                        this.mPlaylistEntries.clear();
                        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            if (readLine.length() > 0 && readLine.charAt(0) != '#') {
                                cachePlaylistEntry(readLine, str2);
                            }
                        }
                        processCachedPlaylist(cursor, contentValues, uri);
                    } catch (IOException e) {
                        e = e;
                        bufferedReader2 = bufferedReader;
                        Log.e(TAG, "IOException in MediaScanner.processM3uPlayList()", e);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException e2) {
                                Log.e(TAG, "IOException in MediaScanner.processM3uPlayList()", e2);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        bufferedReader2 = bufferedReader;
                        th = th;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e3) {
                                Log.e(TAG, "IOException in MediaScanner.processM3uPlayList()", e3);
                            }
                        }
                        throw th;
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        Log.e(TAG, "IOException in MediaScanner.processM3uPlayList()", e4);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
        }
    }

    private void processPlayList(FileEntry fileEntry, Cursor cursor) throws RemoteException {
        Uri withAppendedPath;
        String str = fileEntry.mPath;
        ContentValues contentValues = new ContentValues();
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf < 0) {
            throw new IllegalArgumentException("bad path " + str);
        }
        long j = fileEntry.mRowId;
        String asString = contentValues.getAsString("name");
        String str2 = asString;
        if (asString == null) {
            String asString2 = contentValues.getAsString("title");
            str2 = asString2;
            if (asString2 == null) {
                int lastIndexOf2 = str.lastIndexOf(46);
                str2 = lastIndexOf2 < 0 ? str.substring(lastIndexOf + 1) : str.substring(lastIndexOf + 1, lastIndexOf2);
            }
        }
        contentValues.put("name", str2);
        contentValues.put("date_modified", Long.valueOf(fileEntry.mLastModified));
        if (j == 0) {
            contentValues.put("_data", str);
            Uri insert = this.mMediaProvider.insert(this.mPackageName, this.mPlaylistsUri, contentValues);
            ContentUris.parseId(insert);
            withAppendedPath = Uri.withAppendedPath(insert, "members");
        } else {
            Uri withAppendedId = ContentUris.withAppendedId(this.mPlaylistsUri, j);
            this.mMediaProvider.update(this.mPackageName, withAppendedId, contentValues, null, null);
            withAppendedPath = Uri.withAppendedPath(withAppendedId, "members");
            this.mMediaProvider.delete(this.mPackageName, withAppendedPath, null, null);
        }
        String substring = str.substring(0, lastIndexOf + 1);
        MediaFile.MediaFileType fileType = MediaFile.getFileType(str);
        int i = fileType == null ? 0 : fileType.fileType;
        if (i == 41) {
            processM3uPlayList(str, substring, withAppendedPath, contentValues, cursor);
        } else if (i == 42) {
            processPlsPlayList(str, substring, withAppendedPath, contentValues, cursor);
        } else if (i == 43) {
            processWplPlayList(str, substring, withAppendedPath, contentValues, cursor);
        }
    }

    private void processPlayLists() throws RemoteException {
        Iterator<FileEntry> it = this.mPlayLists.iterator();
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            Cursor query = this.mMediaProvider.query(this.mPackageName, this.mFilesUri, FILES_PRESCAN_PROJECTION, "media_type=2", null, null, null);
            while (true) {
                cursor2 = query;
                cursor = query;
                if (!it.hasNext()) {
                    break;
                }
                FileEntry next = it.next();
                if (next.mLastModifiedChanged) {
                    processPlayList(next, query);
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (RemoteException e) {
            if (cursor2 != null) {
                cursor2.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private void processPlsPlayList(String str, String str2, Uri uri, ContentValues contentValues, Cursor cursor) {
        BufferedReader bufferedReader;
        int indexOf;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                File file = new File(str);
                bufferedReader = null;
                if (file.exists()) {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)), 8192);
                    try {
                        this.mPlaylistEntries.clear();
                        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            if (readLine.startsWith("File") && (indexOf = readLine.indexOf(61)) > 0) {
                                cachePlaylistEntry(readLine.substring(indexOf + 1), str2);
                            }
                        }
                        processCachedPlaylist(cursor, contentValues, uri);
                    } catch (IOException e) {
                        e = e;
                        bufferedReader2 = bufferedReader;
                        Log.e(TAG, "IOException in MediaScanner.processPlsPlayList()", e);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException e2) {
                                Log.e(TAG, "IOException in MediaScanner.processPlsPlayList()", e2);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        bufferedReader2 = bufferedReader;
                        th = th;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e3) {
                                Log.e(TAG, "IOException in MediaScanner.processPlsPlayList()", e3);
                            }
                        }
                        throw th;
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        Log.e(TAG, "IOException in MediaScanner.processPlsPlayList()", e4);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
        }
    }

    private void processWplPlayList(String str, String str2, Uri uri, ContentValues contentValues, Cursor cursor) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File file = new File(str);
                fileInputStream = null;
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        this.mPlaylistEntries.clear();
                        Xml.parse(fileInputStream, Xml.findEncodingByName("UTF-8"), new WplHandler(str2, uri, cursor).getContentHandler());
                        processCachedPlaylist(cursor, contentValues, uri);
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return;
                            } catch (IOException e2) {
                                Log.e(TAG, "IOException in MediaScanner.processWplPlayList()", e2);
                                return;
                            }
                        }
                        return;
                    } catch (SAXException e3) {
                        e = e3;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return;
                            } catch (IOException e4) {
                                Log.e(TAG, "IOException in MediaScanner.processWplPlayList()", e4);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        fileInputStream2 = fileInputStream;
                        th = th;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e5) {
                                Log.e(TAG, "IOException in MediaScanner.processWplPlayList()", e5);
                            }
                        }
                        throw th;
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e6) {
                        Log.e(TAG, "IOException in MediaScanner.processWplPlayList()", e6);
                    }
                }
            } catch (IOException e7) {
                e = e7;
                fileInputStream = null;
            } catch (SAXException e8) {
                e = e8;
                fileInputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void pruneDeadThumbnailFiles() {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.media.MediaScanner.pruneDeadThumbnailFiles():void");
    }

    private void releaseResources() {
        if (this.mDrmManagerClient != null) {
            this.mDrmManagerClient.release();
            this.mDrmManagerClient = null;
        }
    }

    private void setDefaultRingtoneFileNames() {
        String str = SystemProperties.get("ro.config.ringtone");
        int phoneCount = TelephonyManager.getDefault().getPhoneCount();
        this.mDefaultRingtoneFilenames = new String[phoneCount];
        this.mDefaultRingtonesSet = new boolean[phoneCount];
        this.mDefaultRingtoneFilenames[0] = SystemProperties.get("ro.config.ringtone");
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= phoneCount) {
                this.mDefaultNotificationFilename = SystemProperties.get("ro.config.notification_sound");
                this.mDefaultAlarmAlertFilename = SystemProperties.get("ro.config.alarm_alert");
                return;
            }
            this.mDefaultRingtoneFilenames[i2] = SystemProperties.get("ro.config.ringtone_" + (i2 + 1), str);
            i = i2 + 1;
        }
    }

    public native byte[] extractAlbumArt(FileDescriptor fileDescriptor);

    protected void finalize() {
        this.mContext.getContentResolver().releaseProvider(this.mMediaProvider);
        native_finalize();
    }

    FileEntry makeEntryFor(String str) {
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            Cursor query = this.mMediaProvider.query(this.mPackageName, this.mFilesUriNoNotify, FILES_PRESCAN_PROJECTION, "_data=?", new String[]{str}, null, null);
            if (!query.moveToFirst()) {
                if (query != null) {
                    query.close();
                    return null;
                }
                return null;
            }
            cursor2 = query;
            cursor = query;
            FileEntry fileEntry = new FileEntry(query.getLong(0), str, query.getLong(3), query.getInt(2));
            if (query != null) {
                query.close();
            }
            return fileEntry;
        } catch (RemoteException e) {
            if (cursor2 != null) {
                cursor2.close();
                return null;
            }
            return null;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void release() {
        native_finalize();
    }

    public void scanDirectories(String[] strArr, String str) {
        try {
            System.currentTimeMillis();
            initialize(str);
            prescan(null, true);
            System.currentTimeMillis();
            this.mMediaInserter = new MediaInserter(this.mMediaProvider, this.mPackageName, 500);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= strArr.length) {
                    this.mMediaInserter.flushAll();
                    this.mMediaInserter = null;
                    System.currentTimeMillis();
                    postscan(strArr);
                    System.currentTimeMillis();
                    return;
                }
                processDirectory(strArr[i2], this.mClient);
                i = i2 + 1;
            }
        } catch (SQLException e) {
            Log.e(TAG, "SQLException in MediaScanner.scan()", e);
        } catch (RemoteException e2) {
            Log.e(TAG, "RemoteException in MediaScanner.scan()", e2);
        } catch (UnsupportedOperationException e3) {
            Log.e(TAG, "UnsupportedOperationException in MediaScanner.scan()", e3);
        } finally {
            releaseResources();
        }
    }

    public void scanMtpFile(String str, String str2, int i, int i2) {
        Cursor cursor;
        initialize(str2);
        MediaFile.MediaFileType fileType = MediaFile.getFileType(str);
        int i3 = fileType == null ? 0 : fileType.fileType;
        File file = new File(str);
        long lastModified = file.lastModified() / 1000;
        if (!MediaFile.isAudioFileType(i3) && !MediaFile.isVideoFileType(i3) && !MediaFile.isImageFileType(i3) && !MediaFile.isPlayListFileType(i3) && !MediaFile.isDrmFileType(i3)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_size", Long.valueOf(file.length()));
            contentValues.put("date_modified", Long.valueOf(lastModified));
            try {
                this.mMediaProvider.update(this.mPackageName, MediaStore.Files.getMtpObjectsUri(str2), contentValues, "_id=?", new String[]{Integer.toString(i)});
                return;
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException in scanMtpFile", e);
                return;
            }
        }
        this.mMtpObjectHandle = i;
        AutoCloseable autoCloseable = null;
        AutoCloseable autoCloseable2 = null;
        try {
            try {
                if (MediaFile.isPlayListFileType(i3)) {
                    prescan(null, true);
                    FileEntry makeEntryFor = makeEntryFor(str);
                    cursor = null;
                    if (makeEntryFor != null) {
                        cursor = this.mMediaProvider.query(this.mPackageName, this.mFilesUri, FILES_PRESCAN_PROJECTION, null, null, null, null);
                        processPlayList(makeEntryFor, cursor);
                    }
                } else {
                    prescan(str, false);
                    this.mClient.doScanFile(str, fileType.mimeType, lastModified, file.length(), i2 == 12289, true, isNoMediaPath(str));
                    cursor = null;
                }
                this.mMtpObjectHandle = 0;
                if (cursor != null) {
                    cursor.close();
                }
                releaseResources();
            } catch (RemoteException e2) {
                Log.e(TAG, "RemoteException in MediaScanner.scanFile()", e2);
                this.mMtpObjectHandle = 0;
                if (0 != 0) {
                    autoCloseable.close();
                }
                releaseResources();
            }
        } catch (Throwable th) {
            this.mMtpObjectHandle = 0;
            if (0 != 0) {
                autoCloseable2.close();
            }
            releaseResources();
            throw th;
        }
    }

    public Uri scanSingleFile(String str, String str2, String str3) {
        try {
            try {
                initialize(str2);
                prescan(str, true);
                File file = new File(str);
                if (file.exists()) {
                    return this.mClient.doScanFile(str, str3, file.lastModified() / 1000, file.length(), file.isDirectory(), true, isNoMediaPath(str));
                }
                releaseResources();
                return null;
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException in MediaScanner.scanFile()", e);
                releaseResources();
                return null;
            }
        } finally {
            releaseResources();
        }
    }

    public native void setLocale(String str);
}
