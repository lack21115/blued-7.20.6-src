package com.tencent.txcopyrightedmedia.impl.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/f.class */
public final class f extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private b f40098a;

    public f(Context context, b bVar) {
        super(context, "m4a_media", null, 5);
        this.f40098a = bVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE m4a_uri_cache(_id INTEGER PRIMARY KEY AUTOINCREMENT,url VARCHAR NOT NULL,music_id VARCHAR,music_ext_id VARCHAR,content BLOB,content_file_path VARCHAR,content_length INTEGER,UNIQUE(url,music_id,music_ext_id))");
        sQLiteDatabase.execSQL("CREATE TABLE m4a_file_id_cache(_id INTEGER PRIMARY KEY AUTOINCREMENT,music_id VARCHAR NOT NULL,file_id VARCHAR NOT NULL,url VARCHAR NOT NULL,music_ext_id VARCHAR NOT NULL,cache_progress INTEGER,overlay_key VARCHAR,overlay_iv VARCHAR,date INTEGER,source_type INTEGER,UNIQUE(music_id,file_id,music_ext_id))");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE m4a_uri_cache");
        sQLiteDatabase.execSQL("DROP TABLE m4a_file_id_cache");
        d.a();
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        b bVar = this.f40098a;
        int b = (bVar != null ? bVar.d : new g(TXCopyrightedMedia.instance().getApplicationContext())).b();
        int i3 = b;
        if (b == -1) {
            i3 = b;
            if (i < 4) {
                i3 = 0;
            }
        }
        if (i3 != 1) {
            sQLiteDatabase.execSQL("DROP TABLE m4a_uri_cache");
            sQLiteDatabase.execSQL("CREATE TABLE m4a_uri_cache(_id INTEGER PRIMARY KEY AUTOINCREMENT,url VARCHAR NOT NULL,music_id VARCHAR,music_ext_id VARCHAR,content BLOB,content_file_path VARCHAR,content_length INTEGER,UNIQUE(url,music_id,music_ext_id))");
        } else {
            if (i < 2) {
                sQLiteDatabase.execSQL("ALTER TABLE m4a_uri_cache ADD COLUMN content_file_path VARCHAR");
            }
            if (i < 3) {
                sQLiteDatabase.execSQL("ALTER TABLE m4a_uri_cache RENAME TO m4a_uri_cache_temp;");
                sQLiteDatabase.execSQL("CREATE TABLE m4a_uri_cache(_id INTEGER PRIMARY KEY AUTOINCREMENT,url VARCHAR NOT NULL,music_id VARCHAR,bitrate VARCHAR,content BLOB,content_file_path VARCHAR,UNIQUE(url,music_id,bitrate))");
                sQLiteDatabase.execSQL("INSERT INTO m4a_uri_cache (_id, url,music_id, bitrate, content, content_file_path) SELECT _id, url, music_id, 'audio/lo', content, content_file_path FROM m4a_uri_cache_temp;");
                sQLiteDatabase.execSQL("DROP TABLE m4a_uri_cache_temp");
            }
            if (i < 4) {
                sQLiteDatabase.execSQL("DROP TABLE m4a_uri_cache");
                sQLiteDatabase.execSQL("CREATE TABLE m4a_uri_cache(_id INTEGER PRIMARY KEY AUTOINCREMENT,url VARCHAR NOT NULL,music_id VARCHAR,bitrate VARCHAR,content BLOB,content_file_path VARCHAR,content_length INTEGER,UNIQUE(url,music_id,bitrate))");
            }
            if (i < 5) {
                sQLiteDatabase.execSQL("ALTER TABLE m4a_uri_cache RENAME TO m4a_uri_cache_temp;");
                sQLiteDatabase.execSQL("CREATE TABLE m4a_uri_cache(_id INTEGER PRIMARY KEY AUTOINCREMENT,url VARCHAR NOT NULL,music_id VARCHAR,music_ext_id VARCHAR,content BLOB,content_file_path VARCHAR,content_length INTEGER,UNIQUE(url,music_id,music_ext_id))");
                sQLiteDatabase.execSQL("INSERT INTO m4a_uri_cache (_id, url,music_id, music_ext_id, content, content_file_path, content_length) SELECT _id, url, music_id, bitrate, content, content_file_path, content_length FROM m4a_uri_cache_temp;");
                sQLiteDatabase.execSQL("DROP TABLE m4a_uri_cache_temp");
            }
        }
        if (i3 != 1) {
            sQLiteDatabase.execSQL("DROP TABLE m4a_file_id_cache");
            sQLiteDatabase.execSQL("CREATE TABLE m4a_file_id_cache(_id INTEGER PRIMARY KEY AUTOINCREMENT,music_id VARCHAR NOT NULL,file_id VARCHAR NOT NULL,url VARCHAR NOT NULL,music_ext_id VARCHAR NOT NULL,cache_progress INTEGER,overlay_key VARCHAR,overlay_iv VARCHAR,date INTEGER,source_type INTEGER,UNIQUE(music_id,file_id,music_ext_id))");
        } else {
            if (i < 3) {
                sQLiteDatabase.execSQL("ALTER TABLE m4a_file_id_cache RENAME TO m4a_file_id_cache_temp;");
                sQLiteDatabase.execSQL("CREATE TABLE m4a_file_id_cache(_id INTEGER PRIMARY KEY AUTOINCREMENT,music_id VARCHAR NOT NULL,file_id VARCHAR NOT NULL,url VARCHAR NOT NULL,bitrate VARCHAR NOT NULL,cache_progress INTEGER,overlay_key VARCHAR,overlay_iv VARCHAR,date INTEGER,UNIQUE(music_id,file_id,bitrate))");
                sQLiteDatabase.execSQL("INSERT INTO m4a_file_id_cache (_id, music_id, file_id, url, cache_progress, overlay_key, overlay_iv, date, bitrate) SELECT _id, music_id, file_id, url, cache_progress, overlay_key, overlay_iv, date, 'audio/lo' FROM m4a_file_id_cache_temp;");
                sQLiteDatabase.execSQL("DROP TABLE m4a_file_id_cache_temp");
            }
            if (i < 4) {
                sQLiteDatabase.execSQL("DROP TABLE m4a_file_id_cache");
                sQLiteDatabase.execSQL("CREATE TABLE m4a_file_id_cache(_id INTEGER PRIMARY KEY AUTOINCREMENT,music_id VARCHAR NOT NULL,file_id VARCHAR NOT NULL,url VARCHAR NOT NULL,bitrate VARCHAR NOT NULL,cache_progress INTEGER,overlay_key VARCHAR,overlay_iv VARCHAR,date INTEGER,source_type INTEGER,UNIQUE(music_id,file_id,bitrate))");
            }
            if (i < 5) {
                sQLiteDatabase.execSQL("ALTER TABLE m4a_file_id_cache RENAME TO m4a_file_id_cache_temp;");
                sQLiteDatabase.execSQL("CREATE TABLE m4a_file_id_cache(_id INTEGER PRIMARY KEY AUTOINCREMENT,music_id VARCHAR NOT NULL,file_id VARCHAR NOT NULL,url VARCHAR NOT NULL,music_ext_id VARCHAR NOT NULL,cache_progress INTEGER,overlay_key VARCHAR,overlay_iv VARCHAR,date INTEGER,source_type INTEGER,UNIQUE(music_id,file_id,music_ext_id))");
                sQLiteDatabase.execSQL("INSERT INTO m4a_file_id_cache (_id, music_id, file_id, url, cache_progress, overlay_key, overlay_iv, date, music_ext_id, source_type) SELECT _id, music_id, file_id, url, cache_progress, overlay_key, overlay_iv, date, bitrate, source_type FROM m4a_file_id_cache_temp;");
                sQLiteDatabase.execSQL("DROP TABLE m4a_file_id_cache_temp");
            }
        }
        if (i3 != 1) {
            d.a();
        }
    }
}
