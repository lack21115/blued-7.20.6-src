package android.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

/* loaded from: source-9557208-dex2jar.jar:android/provider/LocalGroups.class */
public class LocalGroups {
    public static final String AUTHORITY = "com.android.contacts.groups";
    public static final Uri AUTHORITY_URI = Uri.parse("content://com.android.contacts.groups");
    public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "local-groups");

    /* loaded from: source-9557208-dex2jar.jar:android/provider/LocalGroups$Group.class */
    public static class Group {
        private int count;
        private long id = -1;
        private String title = "";

        public static Group restoreGroup(Cursor cursor) {
            if (cursor == null && cursor.getCount() == 0) {
                return null;
            }
            Group group = new Group();
            group.setId(cursor.getLong(cursor.getColumnIndex("_id")));
            group.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            group.setCount(cursor.getInt(cursor.getColumnIndex("count")));
            return group;
        }

        public static Group restoreGroupById(ContentResolver contentResolver, long j) {
            Cursor cursor = null;
            try {
                Cursor query = contentResolver.query(ContentUris.withAppendedId(LocalGroups.CONTENT_URI, j), null, null, null, null);
                if (query == null || !query.moveToNext()) {
                    if (query != null) {
                        query.close();
                        return null;
                    }
                    return null;
                }
                cursor = query;
                Group restoreGroup = restoreGroup(query);
                if (query != null) {
                    query.close();
                }
                return restoreGroup;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        public boolean delete(ContentResolver contentResolver) {
            contentResolver.delete(ContactsContract.Data.CONTENT_URI, "mimetype=? and data1=?", new String[]{ContactsContract.CommonDataKinds.LocalGroup.CONTENT_ITEM_TYPE, String.valueOf(getId())});
            return contentResolver.delete(LocalGroups.CONTENT_URI, "_id=?", new String[]{String.valueOf(this.id)}) > 0;
        }

        public int getCount() {
            return this.count;
        }

        public long getId() {
            return this.id;
        }

        public String getTitle() {
            return this.title;
        }

        public boolean save(ContentResolver contentResolver) {
            Uri insert;
            if (contentResolver == null || (insert = contentResolver.insert(LocalGroups.CONTENT_URI, toContentValues())) == null) {
                return false;
            }
            setId(ContentUris.parseId(insert));
            return true;
        }

        public void setCount(int i) {
            this.count = i;
        }

        public void setId(long j) {
            this.id = j;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public ContentValues toContentValues() {
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", getTitle());
            contentValues.put("count", Integer.valueOf(getCount()));
            return contentValues;
        }

        public boolean update(ContentResolver contentResolver) {
            boolean z = true;
            if (contentResolver == null) {
                return false;
            }
            if (contentResolver.update(LocalGroups.CONTENT_URI, toContentValues(), "_id=?", new String[]{String.valueOf(this.id)}) <= 0) {
                z = false;
            }
            return z;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/LocalGroups$GroupColumns.class */
    public interface GroupColumns {
        public static final String COUNT = "count";
        public static final String TITLE = "title";
        public static final String _ID = "_id";
    }
}
