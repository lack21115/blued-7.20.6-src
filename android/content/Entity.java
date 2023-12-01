package android.content;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/content/Entity.class */
public final class Entity {
    private final ArrayList<NamedContentValues> mSubValues = new ArrayList<>();
    private final ContentValues mValues;

    /* loaded from: source-9557208-dex2jar.jar:android/content/Entity$NamedContentValues.class */
    public static class NamedContentValues {
        public final Uri uri;
        public final ContentValues values;

        public NamedContentValues(Uri uri, ContentValues contentValues) {
            this.uri = uri;
            this.values = contentValues;
        }
    }

    public Entity(ContentValues contentValues) {
        this.mValues = contentValues;
    }

    public void addSubValue(Uri uri, ContentValues contentValues) {
        this.mSubValues.add(new NamedContentValues(uri, contentValues));
    }

    public ContentValues getEntityValues() {
        return this.mValues;
    }

    public ArrayList<NamedContentValues> getSubValues() {
        return this.mSubValues;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Entity: ").append(getEntityValues());
        Iterator<NamedContentValues> it = getSubValues().iterator();
        while (it.hasNext()) {
            NamedContentValues next = it.next();
            sb.append("\n  ").append(next.uri);
            sb.append("\n  -> ").append(next.values);
        }
        return sb.toString();
    }
}
