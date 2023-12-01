package android.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.MiniThumbFile;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.Contacts;
import android.util.Log;
import com.anythink.expressad.d.a.b;
import com.huawei.hms.ads.fw;
import com.huawei.openalliance.ad.constant.ax;
import com.oplus.quickgame.sdk.hall.Constant;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore.class */
public final class MediaStore {
    public static final String ACTION_IMAGE_CAPTURE = "android.media.action.IMAGE_CAPTURE";
    public static final String ACTION_IMAGE_CAPTURE_SECURE = "android.media.action.IMAGE_CAPTURE_SECURE";
    public static final String ACTION_MTP_SESSION_END = "android.provider.action.MTP_SESSION_END";
    public static final String ACTION_VIDEO_CAPTURE = "android.media.action.VIDEO_CAPTURE";
    public static final String AUTHORITY = "media";
    private static final String CONTENT_AUTHORITY_SLASH = "content://media/";
    public static final String EXTRA_DURATION_LIMIT = "android.intent.extra.durationLimit";
    public static final String EXTRA_FINISH_ON_COMPLETION = "android.intent.extra.finishOnCompletion";
    public static final String EXTRA_FULL_SCREEN = "android.intent.extra.fullScreen";
    public static final String EXTRA_MEDIA_ALBUM = "android.intent.extra.album";
    public static final String EXTRA_MEDIA_ARTIST = "android.intent.extra.artist";
    public static final String EXTRA_MEDIA_FOCUS = "android.intent.extra.focus";
    public static final String EXTRA_MEDIA_GENRE = "android.intent.extra.genre";
    public static final String EXTRA_MEDIA_PLAYLIST = "android.intent.extra.playlist";
    public static final String EXTRA_MEDIA_RADIO_CHANNEL = "android.intent.extra.radio_channel";
    public static final String EXTRA_MEDIA_TITLE = "android.intent.extra.title";
    public static final String EXTRA_OUTPUT = "output";
    public static final String EXTRA_SCREEN_ORIENTATION = "android.intent.extra.screenOrientation";
    public static final String EXTRA_SHOW_ACTION_ICONS = "android.intent.extra.showActionIcons";
    public static final String EXTRA_SIZE_LIMIT = "android.intent.extra.sizeLimit";
    public static final String EXTRA_VIDEO_QUALITY = "android.intent.extra.videoQuality";
    public static final String INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH = "android.media.action.MEDIA_PLAY_FROM_SEARCH";
    public static final String INTENT_ACTION_MEDIA_SEARCH = "android.intent.action.MEDIA_SEARCH";
    @Deprecated
    public static final String INTENT_ACTION_MUSIC_PLAYER = "android.intent.action.MUSIC_PLAYER";
    public static final String INTENT_ACTION_STILL_IMAGE_CAMERA = "android.media.action.STILL_IMAGE_CAMERA";
    public static final String INTENT_ACTION_STILL_IMAGE_CAMERA_SECURE = "android.media.action.STILL_IMAGE_CAMERA_SECURE";
    public static final String INTENT_ACTION_TEXT_OPEN_FROM_SEARCH = "android.media.action.TEXT_OPEN_FROM_SEARCH";
    public static final String INTENT_ACTION_VIDEO_CAMERA = "android.media.action.VIDEO_CAMERA";
    public static final String INTENT_ACTION_VIDEO_PLAY_FROM_SEARCH = "android.media.action.VIDEO_PLAY_FROM_SEARCH";
    public static final String MEDIA_IGNORE_FILENAME = ".nomedia";
    public static final String MEDIA_SCANNER_VOLUME = "volume";
    public static final String PARAM_DELETE_DATA = "deletedata";
    private static final String TAG = "MediaStore";
    public static final String UNHIDE_CALL = "unhide";
    public static final String UNKNOWN_STRING = "<unknown>";

    /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Audio.class */
    public static final class Audio {

        /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Audio$AlbumColumns.class */
        public interface AlbumColumns {
            public static final String ALBUM = "album";
            public static final String ALBUM_ART = "album_art";
            public static final String ALBUM_ID = "album_id";
            public static final String ALBUM_KEY = "album_key";
            public static final String ARTIST = "artist";
            public static final String FIRST_YEAR = "minyear";
            public static final String LAST_YEAR = "maxyear";
            public static final String NUMBER_OF_SONGS = "numsongs";
            public static final String NUMBER_OF_SONGS_FOR_ARTIST = "numsongs_by_artist";
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Audio$Albums.class */
        public static final class Albums implements BaseColumns, AlbumColumns {
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/albums";
            public static final String DEFAULT_SORT_ORDER = "album_key";
            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/album";
            public static final Uri INTERNAL_CONTENT_URI = getContentUri(UMModuleRegister.INNER);
            public static final Uri EXTERNAL_CONTENT_URI = getContentUri(Constant.Param.KEY_RPK_EXTERNAL);

            public static Uri getContentUri(String str) {
                return Uri.parse(MediaStore.CONTENT_AUTHORITY_SLASH + str + "/audio/albums");
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Audio$ArtistColumns.class */
        public interface ArtistColumns {
            public static final String ARTIST = "artist";
            public static final String ARTIST_KEY = "artist_key";
            public static final String NUMBER_OF_ALBUMS = "number_of_albums";
            public static final String NUMBER_OF_TRACKS = "number_of_tracks";
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Audio$Artists.class */
        public static final class Artists implements BaseColumns, ArtistColumns {
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/artists";
            public static final String DEFAULT_SORT_ORDER = "artist_key";
            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/artist";
            public static final Uri INTERNAL_CONTENT_URI = getContentUri(UMModuleRegister.INNER);
            public static final Uri EXTERNAL_CONTENT_URI = getContentUri(Constant.Param.KEY_RPK_EXTERNAL);

            /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Audio$Artists$Albums.class */
            public static final class Albums implements AlbumColumns {
                public static final Uri getContentUri(String str, long j) {
                    return Uri.parse(MediaStore.CONTENT_AUTHORITY_SLASH + str + "/audio/artists/" + j + "/albums");
                }
            }

            public static Uri getContentUri(String str) {
                return Uri.parse(MediaStore.CONTENT_AUTHORITY_SLASH + str + "/audio/artists");
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Audio$AudioColumns.class */
        public interface AudioColumns extends MediaColumns {
            public static final String ALBUM = "album";
            public static final String ALBUM_ARTIST = "album_artist";
            public static final String ALBUM_ID = "album_id";
            public static final String ALBUM_KEY = "album_key";
            public static final String ARTIST = "artist";
            public static final String ARTIST_ID = "artist_id";
            public static final String ARTIST_KEY = "artist_key";
            public static final String BOOKMARK = "bookmark";
            public static final String COMPILATION = "compilation";
            public static final String COMPOSER = "composer";
            public static final String DURATION = "duration";
            public static final String GENRE = "genre";
            public static final String IS_ALARM = "is_alarm";
            public static final String IS_MUSIC = "is_music";
            public static final String IS_NOTIFICATION = "is_notification";
            public static final String IS_PODCAST = "is_podcast";
            public static final String IS_RINGTONE = "is_ringtone";
            public static final String TITLE_KEY = "title_key";
            public static final String TRACK = "track";
            public static final String YEAR = "year";
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Audio$Genres.class */
        public static final class Genres implements BaseColumns, GenresColumns {
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/genre";
            public static final String DEFAULT_SORT_ORDER = "name";
            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/genre";
            public static final Uri INTERNAL_CONTENT_URI = getContentUri(UMModuleRegister.INNER);
            public static final Uri EXTERNAL_CONTENT_URI = getContentUri(Constant.Param.KEY_RPK_EXTERNAL);

            /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Audio$Genres$Members.class */
            public static final class Members implements AudioColumns {
                public static final String AUDIO_ID = "audio_id";
                public static final String CONTENT_DIRECTORY = "members";
                public static final String DEFAULT_SORT_ORDER = "title_key";
                public static final String GENRE_ID = "genre_id";

                public static final Uri getContentUri(String str, long j) {
                    return Uri.parse(MediaStore.CONTENT_AUTHORITY_SLASH + str + "/audio/genres/" + j + "/members");
                }
            }

            public static Uri getContentUri(String str) {
                return Uri.parse(MediaStore.CONTENT_AUTHORITY_SLASH + str + "/audio/genres");
            }

            public static Uri getContentUriForAudioId(String str, int i) {
                return Uri.parse(MediaStore.CONTENT_AUTHORITY_SLASH + str + "/audio/media/" + i + "/genres");
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Audio$GenresColumns.class */
        public interface GenresColumns {
            public static final String NAME = "name";
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Audio$Media.class */
        public static final class Media implements AudioColumns {
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/audio";
            public static final String DEFAULT_SORT_ORDER = "title_key";
            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/audio";
            public static final Uri EXTERNAL_CONTENT_URI;
            private static final String[] EXTERNAL_PATHS;
            public static final String EXTRA_MAX_BYTES = "android.provider.MediaStore.extra.MAX_BYTES";
            public static final Uri INTERNAL_CONTENT_URI;
            public static final String RECORD_SOUND_ACTION = "android.provider.MediaStore.RECORD_SOUND";

            static {
                String str = System.getenv("SECONDARY_STORAGE");
                if (str != null) {
                    EXTERNAL_PATHS = str.split(":");
                } else {
                    EXTERNAL_PATHS = new String[0];
                }
                INTERNAL_CONTENT_URI = getContentUri(UMModuleRegister.INNER);
                EXTERNAL_CONTENT_URI = getContentUri(Constant.Param.KEY_RPK_EXTERNAL);
            }

            public static Uri getContentUri(String str) {
                return Uri.parse(MediaStore.CONTENT_AUTHORITY_SLASH + str + "/audio/media");
            }

            public static Uri getContentUriForPath(String str) {
                String[] strArr = EXTERNAL_PATHS;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return str.startsWith(Environment.getExternalStorageDirectory().getPath()) ? EXTERNAL_CONTENT_URI : INTERNAL_CONTENT_URI;
                    } else if (str.startsWith(strArr[i2])) {
                        return EXTERNAL_CONTENT_URI;
                    } else {
                        i = i2 + 1;
                    }
                }
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Audio$Playlists.class */
        public static final class Playlists implements BaseColumns, PlaylistsColumns {
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/playlist";
            public static final String DEFAULT_SORT_ORDER = "name";
            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/playlist";
            public static final Uri INTERNAL_CONTENT_URI = getContentUri(UMModuleRegister.INNER);
            public static final Uri EXTERNAL_CONTENT_URI = getContentUri(Constant.Param.KEY_RPK_EXTERNAL);

            /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Audio$Playlists$Members.class */
            public static final class Members implements AudioColumns {
                public static final String AUDIO_ID = "audio_id";
                public static final String CONTENT_DIRECTORY = "members";
                public static final String DEFAULT_SORT_ORDER = "play_order";
                public static final String PLAYLIST_ID = "playlist_id";
                public static final String PLAY_ORDER = "play_order";
                public static final String _ID = "_id";

                public static final Uri getContentUri(String str, long j) {
                    return Uri.parse(MediaStore.CONTENT_AUTHORITY_SLASH + str + "/audio/playlists/" + j + "/members");
                }

                public static final boolean moveItem(ContentResolver contentResolver, long j, int i, int i2) {
                    Uri build = getContentUri(Constant.Param.KEY_RPK_EXTERNAL, j).buildUpon().appendEncodedPath(String.valueOf(i)).appendQueryParameter("move", fw.Code).build();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("play_order", Integer.valueOf(i2));
                    return contentResolver.update(build, contentValues, null, null) != 0;
                }
            }

            public static Uri getContentUri(String str) {
                return Uri.parse(MediaStore.CONTENT_AUTHORITY_SLASH + str + "/audio/playlists");
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Audio$PlaylistsColumns.class */
        public interface PlaylistsColumns {
            public static final String DATA = "_data";
            public static final String DATE_ADDED = "date_added";
            public static final String DATE_MODIFIED = "date_modified";
            public static final String NAME = "name";
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Audio$Radio.class */
        public static final class Radio {
            public static final String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/radio";

            private Radio() {
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0099, code lost:
            if (r5.endsWith(",a") != false) goto L45;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.String keyFor(java.lang.String r5) {
            /*
                Method dump skipped, instructions count: 287
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.provider.MediaStore.Audio.keyFor(java.lang.String):java.lang.String");
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Files.class */
    public static final class Files {

        /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Files$FileColumns.class */
        public interface FileColumns extends MediaColumns {
            public static final String FORMAT = "format";
            public static final String MEDIA_TYPE = "media_type";
            public static final int MEDIA_TYPE_AUDIO = 2;
            public static final int MEDIA_TYPE_IMAGE = 1;
            public static final int MEDIA_TYPE_NONE = 0;
            public static final int MEDIA_TYPE_PLAYLIST = 4;
            public static final int MEDIA_TYPE_VIDEO = 3;
            public static final String MIME_TYPE = "mime_type";
            public static final String PARENT = "parent";
            public static final String STORAGE_ID = "storage_id";
            public static final String TITLE = "title";
        }

        public static Uri getContentUri(String str) {
            return Uri.parse(MediaStore.CONTENT_AUTHORITY_SLASH + str + "/file");
        }

        public static final Uri getContentUri(String str, long j) {
            return Uri.parse(MediaStore.CONTENT_AUTHORITY_SLASH + str + "/file/" + j);
        }

        public static Uri getMtpObjectsUri(String str) {
            return Uri.parse(MediaStore.CONTENT_AUTHORITY_SLASH + str + "/object");
        }

        public static final Uri getMtpObjectsUri(String str, long j) {
            return Uri.parse(MediaStore.CONTENT_AUTHORITY_SLASH + str + "/object/" + j);
        }

        public static final Uri getMtpReferencesUri(String str, long j) {
            return Uri.parse(MediaStore.CONTENT_AUTHORITY_SLASH + str + "/object/" + j + "/references");
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Images.class */
    public static final class Images {

        /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Images$ImageColumns.class */
        public interface ImageColumns extends MediaColumns {
            public static final String BUCKET_DISPLAY_NAME = "bucket_display_name";
            public static final String BUCKET_ID = "bucket_id";
            public static final String DATE_TAKEN = "datetaken";
            public static final String DESCRIPTION = "description";
            public static final String IS_PRIVATE = "isprivate";
            public static final String LATITUDE = "latitude";
            public static final String LONGITUDE = "longitude";
            public static final String MINI_THUMB_MAGIC = "mini_thumb_magic";
            public static final String ORIENTATION = "orientation";
            public static final String PICASA_ID = "picasa_id";
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Images$Media.class */
        public static final class Media implements ImageColumns {
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/image";
            public static final String DEFAULT_SORT_ORDER = "bucket_display_name";
            public static final Uri INTERNAL_CONTENT_URI = getContentUri(UMModuleRegister.INNER);
            public static final Uri EXTERNAL_CONTENT_URI = getContentUri(Constant.Param.KEY_RPK_EXTERNAL);

            private static final Bitmap StoreThumbnail(ContentResolver contentResolver, Bitmap bitmap, long j, float f, float f2, int i) {
                Matrix matrix = new Matrix();
                matrix.setScale(f / bitmap.getWidth(), f2 / bitmap.getHeight());
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                ContentValues contentValues = new ContentValues(4);
                contentValues.put("kind", Integer.valueOf(i));
                contentValues.put("image_id", Integer.valueOf((int) j));
                contentValues.put("height", Integer.valueOf(createBitmap.getHeight()));
                contentValues.put("width", Integer.valueOf(createBitmap.getWidth()));
                try {
                    OutputStream openOutputStream = contentResolver.openOutputStream(contentResolver.insert(Thumbnails.EXTERNAL_CONTENT_URI, contentValues));
                    createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, openOutputStream);
                    openOutputStream.close();
                    return createBitmap;
                } catch (FileNotFoundException e) {
                    return null;
                } catch (IOException e2) {
                    return null;
                }
            }

            public static final Bitmap getBitmap(ContentResolver contentResolver, Uri uri) throws FileNotFoundException, IOException {
                InputStream openInputStream = contentResolver.openInputStream(uri);
                Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream);
                openInputStream.close();
                return decodeStream;
            }

            public static Uri getContentUri(String str) {
                return Uri.parse(MediaStore.CONTENT_AUTHORITY_SLASH + str + "/images/media");
            }

            public static final String insertImage(ContentResolver contentResolver, Bitmap bitmap, String str, String str2) {
                Uri uri;
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", str);
                contentValues.put("description", str2);
                contentValues.put("mime_type", ax.V);
                Uri uri2 = null;
                try {
                    Uri insert = contentResolver.insert(EXTERNAL_CONTENT_URI, contentValues);
                    if (bitmap != null) {
                        OutputStream openOutputStream = contentResolver.openOutputStream(insert);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, openOutputStream);
                        openOutputStream.close();
                        long parseId = ContentUris.parseId(insert);
                        uri2 = insert;
                        StoreThumbnail(contentResolver, Thumbnails.getThumbnail(contentResolver, parseId, 1, null), parseId, 50.0f, 50.0f, 3);
                        uri = insert;
                    } else {
                        Log.e(MediaStore.TAG, "Failed to create thumbnail, removing original");
                        uri2 = insert;
                        contentResolver.delete(insert, null, null);
                        uri = null;
                    }
                } catch (Exception e) {
                    Log.e(MediaStore.TAG, "Failed to insert image", e);
                    uri = uri2;
                    if (uri2 != null) {
                        contentResolver.delete(uri2, null, null);
                        uri = null;
                    }
                }
                String str3 = null;
                if (uri != null) {
                    str3 = uri.toString();
                }
                return str3;
            }

            public static final String insertImage(ContentResolver contentResolver, String str, String str2, String str3) throws FileNotFoundException {
                FileInputStream fileInputStream = new FileInputStream(str);
                try {
                    Bitmap decodeFile = BitmapFactory.decodeFile(str);
                    String insertImage = insertImage(contentResolver, decodeFile, str2, str3);
                    decodeFile.recycle();
                    try {
                        return insertImage;
                    } catch (IOException e) {
                        return insertImage;
                    }
                } finally {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                    }
                }
            }

            public static final Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr) {
                return contentResolver.query(uri, strArr, null, null, "bucket_display_name");
            }

            public static final Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String str2) {
                if (str2 == null) {
                    str2 = "bucket_display_name";
                }
                return contentResolver.query(uri, strArr, str, null, str2);
            }

            public static final Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
                if (str2 == null) {
                    str2 = "bucket_display_name";
                }
                return contentResolver.query(uri, strArr, str, strArr2, str2);
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Images$Thumbnails.class */
        public static class Thumbnails implements BaseColumns {
            public static final String DATA = "_data";
            public static final String DEFAULT_SORT_ORDER = "image_id ASC";
            public static final int FULL_SCREEN_KIND = 2;
            public static final String HEIGHT = "height";
            public static final String IMAGE_ID = "image_id";
            public static final String KIND = "kind";
            public static final int MICRO_KIND = 3;
            public static final int MINI_KIND = 1;
            public static final String THUMB_DATA = "thumb_data";
            public static final String WIDTH = "width";
            public static final Uri INTERNAL_CONTENT_URI = getContentUri(UMModuleRegister.INNER);
            public static final Uri EXTERNAL_CONTENT_URI = getContentUri(Constant.Param.KEY_RPK_EXTERNAL);

            public static void cancelThumbnailRequest(ContentResolver contentResolver, long j) {
                InternalThumbnails.cancelThumbnailRequest(contentResolver, j, EXTERNAL_CONTENT_URI, 0L);
            }

            public static void cancelThumbnailRequest(ContentResolver contentResolver, long j, long j2) {
                InternalThumbnails.cancelThumbnailRequest(contentResolver, j, EXTERNAL_CONTENT_URI, j2);
            }

            public static Uri getContentUri(String str) {
                return Uri.parse(MediaStore.CONTENT_AUTHORITY_SLASH + str + "/images/thumbnails");
            }

            public static Bitmap getThumbnail(ContentResolver contentResolver, long j, int i, BitmapFactory.Options options) {
                return InternalThumbnails.getThumbnail(contentResolver, j, 0L, i, options, EXTERNAL_CONTENT_URI, false);
            }

            public static Bitmap getThumbnail(ContentResolver contentResolver, long j, long j2, int i, BitmapFactory.Options options) {
                return InternalThumbnails.getThumbnail(contentResolver, j, j2, i, options, EXTERNAL_CONTENT_URI, false);
            }

            public static final Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr) {
                return contentResolver.query(uri, strArr, null, null, DEFAULT_SORT_ORDER);
            }

            public static final Cursor queryMiniThumbnail(ContentResolver contentResolver, long j, int i, String[] strArr) {
                return contentResolver.query(EXTERNAL_CONTENT_URI, strArr, "image_id = " + j + " AND kind = " + i, null, null);
            }

            public static final Cursor queryMiniThumbnails(ContentResolver contentResolver, Uri uri, int i, String[] strArr) {
                return contentResolver.query(uri, strArr, "kind = " + i, null, DEFAULT_SORT_ORDER);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$InternalThumbnails.class */
    public static class InternalThumbnails implements BaseColumns {
        static final int DEFAULT_GROUP_ID = 0;
        private static final int FULL_SCREEN_KIND = 2;
        private static final int MICRO_KIND = 3;
        private static final int MINI_KIND = 1;
        private static byte[] sThumbBuf;
        private static final String[] PROJECTION = {"_id", "_data"};
        private static final Object sThumbBufLock = new Object();

        private InternalThumbnails() {
        }

        static void cancelThumbnailRequest(ContentResolver contentResolver, long j, Uri uri, long j2) {
            try {
                Cursor query = contentResolver.query(uri.buildUpon().appendQueryParameter(b.dO, "1").appendQueryParameter("orig_id", String.valueOf(j)).appendQueryParameter(Contacts.GroupMembership.GROUP_ID, String.valueOf(j2)).build(), PROJECTION, null, null, null);
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th) {
                if (0 == 0) {
                    throw th;
                }
                throw new NullPointerException();
            }
        }

        private static Bitmap getMiniThumbFromFile(Cursor cursor, Uri uri, ContentResolver contentResolver, BitmapFactory.Options options) {
            Bitmap bitmap = null;
            Uri uri2 = null;
            Bitmap bitmap2 = null;
            Uri uri3 = null;
            Bitmap bitmap3 = null;
            Uri uri4 = null;
            try {
                long j = cursor.getLong(0);
                cursor.getString(1);
                Uri withAppendedId = ContentUris.withAppendedId(uri, j);
                ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(withAppendedId, "r");
                Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor(), null, options);
                bitmap = decodeFileDescriptor;
                uri2 = withAppendedId;
                bitmap2 = decodeFileDescriptor;
                uri3 = withAppendedId;
                bitmap3 = decodeFileDescriptor;
                uri4 = withAppendedId;
                openFileDescriptor.close();
                return decodeFileDescriptor;
            } catch (FileNotFoundException e) {
                Log.e(MediaStore.TAG, "couldn't open thumbnail " + uri2 + "; " + e);
                return bitmap;
            } catch (IOException e2) {
                Log.e(MediaStore.TAG, "couldn't open thumbnail " + uri3 + "; " + e2);
                return bitmap2;
            } catch (OutOfMemoryError e3) {
                Log.e(MediaStore.TAG, "failed to allocate memory for thumbnail " + uri4 + "; " + e3);
                return bitmap3;
            }
        }

        static Bitmap getThumbnail(ContentResolver contentResolver, long j, long j2, int i, BitmapFactory.Options options, Uri uri, boolean z) {
            Bitmap bitmap;
            Cursor query;
            Bitmap bitmap2;
            Bitmap bitmap3;
            MiniThumbFile miniThumbFile = new MiniThumbFile(z ? Video.Media.EXTERNAL_CONTENT_URI : Images.Media.EXTERNAL_CONTENT_URI);
            AutoCloseable autoCloseable = null;
            AutoCloseable autoCloseable2 = null;
            Bitmap bitmap4 = null;
            Cursor cursor = null;
            try {
                try {
                    if (miniThumbFile.getMagic(j) != 0) {
                        if (i == 3) {
                            synchronized (sThumbBufLock) {
                                if (sThumbBuf == null) {
                                    sThumbBuf = new byte[10000];
                                }
                                bitmap3 = null;
                                if (miniThumbFile.getMiniThumbFromFile(j, sThumbBuf) != null) {
                                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(sThumbBuf, 0, sThumbBuf.length);
                                    bitmap3 = decodeByteArray;
                                    if (decodeByteArray == null) {
                                        Log.w(MediaStore.TAG, "couldn't decode byte array.");
                                        bitmap3 = decodeByteArray;
                                    }
                                }
                            }
                            if (0 != 0) {
                                throw new NullPointerException();
                            }
                            miniThumbFile.deactivate();
                            return bitmap3;
                        }
                        bitmap4 = null;
                        cursor = null;
                        if (i == 1) {
                            Cursor query2 = contentResolver.query(uri, PROJECTION, (z ? "video_id=" : "image_id=") + j, null, null);
                            bitmap4 = null;
                            cursor = query2;
                            if (query2 != null) {
                                bitmap4 = null;
                                cursor = query2;
                                if (query2.moveToFirst()) {
                                    Bitmap miniThumbFromFile = getMiniThumbFromFile(query2, uri, contentResolver, options);
                                    bitmap4 = miniThumbFromFile;
                                    cursor = query2;
                                    if (miniThumbFromFile != null) {
                                        if (query2 != null) {
                                            query2.close();
                                        }
                                        miniThumbFile.deactivate();
                                        return miniThumbFromFile;
                                    }
                                }
                            }
                        }
                    }
                    Uri build = uri.buildUpon().appendQueryParameter("blocking", "1").appendQueryParameter("orig_id", String.valueOf(j)).appendQueryParameter(Contacts.GroupMembership.GROUP_ID, String.valueOf(j2)).build();
                    if (cursor != null) {
                        cursor.close();
                    }
                    Bitmap bitmap5 = bitmap4;
                    query = contentResolver.query(build, PROJECTION, null, null, null);
                } catch (SQLiteException e) {
                    Log.w(MediaStore.TAG, e);
                    if (0 != 0) {
                        autoCloseable2.close();
                    }
                    miniThumbFile.deactivate();
                    bitmap = null;
                }
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    miniThumbFile.deactivate();
                    return null;
                }
                if (i == 3) {
                    Bitmap bitmap6 = bitmap4;
                    synchronized (sThumbBufLock) {
                        Bitmap bitmap7 = bitmap4;
                        if (sThumbBuf == null) {
                            Bitmap bitmap8 = bitmap4;
                            sThumbBuf = new byte[10000];
                        }
                        Bitmap bitmap9 = bitmap4;
                        Arrays.fill(sThumbBuf, (byte) 0);
                        bitmap2 = bitmap4;
                        if (miniThumbFile.getMiniThumbFromFile(j, sThumbBuf) != null) {
                            Bitmap bitmap10 = bitmap4;
                            Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray(sThumbBuf, 0, sThumbBuf.length);
                            bitmap2 = decodeByteArray2;
                            if (decodeByteArray2 == null) {
                                Log.w(MediaStore.TAG, "couldn't decode byte array.");
                                bitmap2 = decodeByteArray2;
                            }
                        }
                    }
                } else if (i != 1) {
                    throw new IllegalArgumentException("Unsupported kind: " + i);
                } else {
                    bitmap2 = bitmap4;
                    if (query.moveToFirst()) {
                        Bitmap bitmap11 = bitmap4;
                        bitmap2 = getMiniThumbFromFile(query, uri, contentResolver, options);
                    }
                }
                bitmap = bitmap2;
                Cursor cursor2 = query;
                if (bitmap2 == null) {
                    Log.v(MediaStore.TAG, "Create the thumbnail in memory: origId=" + j + ", kind=" + i + ", isVideo=" + z);
                    Bitmap bitmap12 = bitmap2;
                    Uri parse = Uri.parse(uri.buildUpon().appendPath(String.valueOf(j)).toString().replaceFirst("thumbnails", MediaStore.AUTHORITY));
                    Cursor cursor3 = query;
                    if (0 == 0) {
                        if (query != null) {
                            query.close();
                        }
                        Bitmap bitmap13 = bitmap2;
                        Cursor query3 = contentResolver.query(parse, PROJECTION, null, null, null);
                        if (query3 == null || !query3.moveToFirst()) {
                            if (query3 != null) {
                                query3.close();
                            }
                            miniThumbFile.deactivate();
                            return null;
                        }
                        Bitmap bitmap14 = bitmap2;
                        cursor3 = query3;
                        if (query3.getString(1) == null) {
                            if (query3 != null) {
                                query3.close();
                            }
                            miniThumbFile.deactivate();
                            return null;
                        }
                    }
                    String string = cursor3.getString(1);
                    bitmap = bitmap2;
                    cursor2 = cursor3;
                    if (string != null) {
                        if (z) {
                            bitmap = ThumbnailUtils.createVideoThumbnail(string, i);
                            cursor2 = cursor3;
                        } else {
                            bitmap = ThumbnailUtils.createImageThumbnail(string, i);
                            cursor2 = cursor3;
                        }
                    }
                }
                if (cursor2 != null) {
                    cursor2.close();
                }
                miniThumbFile.deactivate();
                return bitmap;
            } catch (Throwable th) {
                if (0 != 0) {
                    autoCloseable.close();
                }
                miniThumbFile.deactivate();
                throw th;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$MediaColumns.class */
    public interface MediaColumns extends BaseColumns {
        public static final String DATA = "_data";
        public static final String DATE_ADDED = "date_added";
        public static final String DATE_MODIFIED = "date_modified";
        public static final String DISPLAY_NAME = "_display_name";
        public static final String HEIGHT = "height";
        public static final String IS_DRM = "is_drm";
        public static final String MEDIA_SCANNER_NEW_OBJECT_ID = "media_scanner_new_object_id";
        public static final String MIME_TYPE = "mime_type";
        public static final String SIZE = "_size";
        public static final String TITLE = "title";
        public static final String WIDTH = "width";
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Video.class */
    public static final class Video {
        public static final String DEFAULT_SORT_ORDER = "_display_name";

        /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Video$Media.class */
        public static final class Media implements VideoColumns {
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/video";
            public static final String DEFAULT_SORT_ORDER = "title";
            public static final Uri INTERNAL_CONTENT_URI = getContentUri(UMModuleRegister.INNER);
            public static final Uri EXTERNAL_CONTENT_URI = getContentUri(Constant.Param.KEY_RPK_EXTERNAL);

            public static Uri getContentUri(String str) {
                return Uri.parse(MediaStore.CONTENT_AUTHORITY_SLASH + str + "/video/media");
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Video$Thumbnails.class */
        public static class Thumbnails implements BaseColumns {
            public static final String DATA = "_data";
            public static final String DEFAULT_SORT_ORDER = "video_id ASC";
            public static final int FULL_SCREEN_KIND = 2;
            public static final String HEIGHT = "height";
            public static final String KIND = "kind";
            public static final int MICRO_KIND = 3;
            public static final int MINI_KIND = 1;
            public static final String VIDEO_ID = "video_id";
            public static final String WIDTH = "width";
            public static final Uri INTERNAL_CONTENT_URI = getContentUri(UMModuleRegister.INNER);
            public static final Uri EXTERNAL_CONTENT_URI = getContentUri(Constant.Param.KEY_RPK_EXTERNAL);

            public static void cancelThumbnailRequest(ContentResolver contentResolver, long j) {
                InternalThumbnails.cancelThumbnailRequest(contentResolver, j, EXTERNAL_CONTENT_URI, 0L);
            }

            public static void cancelThumbnailRequest(ContentResolver contentResolver, long j, long j2) {
                InternalThumbnails.cancelThumbnailRequest(contentResolver, j, EXTERNAL_CONTENT_URI, j2);
            }

            public static Uri getContentUri(String str) {
                return Uri.parse(MediaStore.CONTENT_AUTHORITY_SLASH + str + "/video/thumbnails");
            }

            public static Bitmap getThumbnail(ContentResolver contentResolver, long j, int i, BitmapFactory.Options options) {
                return InternalThumbnails.getThumbnail(contentResolver, j, 0L, i, options, EXTERNAL_CONTENT_URI, true);
            }

            public static Bitmap getThumbnail(ContentResolver contentResolver, long j, long j2, int i, BitmapFactory.Options options) {
                return InternalThumbnails.getThumbnail(contentResolver, j, j2, i, options, EXTERNAL_CONTENT_URI, true);
            }
        }

        /* loaded from: source-9557208-dex2jar.jar:android/provider/MediaStore$Video$VideoColumns.class */
        public interface VideoColumns extends MediaColumns {
            public static final String ALBUM = "album";
            public static final String ARTIST = "artist";
            public static final String BOOKMARK = "bookmark";
            public static final String BUCKET_DISPLAY_NAME = "bucket_display_name";
            public static final String BUCKET_ID = "bucket_id";
            public static final String CATEGORY = "category";
            public static final String DATE_TAKEN = "datetaken";
            public static final String DESCRIPTION = "description";
            public static final String DURATION = "duration";
            public static final String IS_PRIVATE = "isprivate";
            public static final String LANGUAGE = "language";
            public static final String LATITUDE = "latitude";
            public static final String LONGITUDE = "longitude";
            public static final String MINI_THUMB_MAGIC = "mini_thumb_magic";
            public static final String RESOLUTION = "resolution";
            public static final String TAGS = "tags";
        }

        public static final Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr) {
            return contentResolver.query(uri, strArr, null, null, "_display_name");
        }
    }

    public static Uri getMediaScannerUri() {
        return Uri.parse("content://media/none/media_scanner");
    }

    public static String getVersion(Context context) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://media/none/version"), null, null, null, null);
        String str = null;
        if (query != null) {
            try {
                if (!query.moveToFirst()) {
                    query.close();
                    return null;
                }
                str = query.getString(0);
            } finally {
                query.close();
            }
        }
        return str;
    }
}
