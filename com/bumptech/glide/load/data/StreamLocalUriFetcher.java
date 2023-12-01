package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/StreamLocalUriFetcher.class */
public class StreamLocalUriFetcher extends LocalUriFetcher<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private static final UriMatcher f7121a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f7121a = uriMatcher;
        uriMatcher.addURI(ContactsContract.AUTHORITY, "contacts/lookup/*/#", 1);
        f7121a.addURI(ContactsContract.AUTHORITY, "contacts/lookup/*", 1);
        f7121a.addURI(ContactsContract.AUTHORITY, "contacts/#/photo", 2);
        f7121a.addURI(ContactsContract.AUTHORITY, "contacts/#", 3);
        f7121a.addURI(ContactsContract.AUTHORITY, "contacts/#/display_photo", 4);
        f7121a.addURI(ContactsContract.AUTHORITY, "phone_lookup/*", 5);
    }

    public StreamLocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    private InputStream a(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    private InputStream c(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int match = f7121a.match(uri);
        if (match != 1) {
            if (match == 3) {
                return a(contentResolver, uri);
            }
            if (match != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri lookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (lookupContact != null) {
            return a(contentResolver, lookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    /* renamed from: a */
    public InputStream b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream c2 = c(uri, contentResolver);
        if (c2 != null) {
            return c2;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<InputStream> c() {
        return InputStream.class;
    }
}
