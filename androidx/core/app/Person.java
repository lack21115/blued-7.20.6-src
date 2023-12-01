package androidx.core.app;

import android.app.Person;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/app/Person.class */
public class Person {

    /* renamed from: a  reason: collision with root package name */
    CharSequence f2387a;
    IconCompat b;

    /* renamed from: c  reason: collision with root package name */
    String f2388c;
    String d;
    boolean e;
    boolean f;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/app/Person$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        CharSequence f2389a;
        IconCompat b;

        /* renamed from: c  reason: collision with root package name */
        String f2390c;
        String d;
        boolean e;
        boolean f;

        public Builder() {
        }

        Builder(Person person) {
            this.f2389a = person.f2387a;
            this.b = person.b;
            this.f2390c = person.f2388c;
            this.d = person.d;
            this.e = person.e;
            this.f = person.f;
        }

        public Person build() {
            return new Person(this);
        }

        public Builder setBot(boolean z) {
            this.e = z;
            return this;
        }

        public Builder setIcon(IconCompat iconCompat) {
            this.b = iconCompat;
            return this;
        }

        public Builder setImportant(boolean z) {
            this.f = z;
            return this;
        }

        public Builder setKey(String str) {
            this.d = str;
            return this;
        }

        public Builder setName(CharSequence charSequence) {
            this.f2389a = charSequence;
            return this;
        }

        public Builder setUri(String str) {
            this.f2390c = str;
            return this;
        }
    }

    Person(Builder builder) {
        this.f2387a = builder.f2389a;
        this.b = builder.b;
        this.f2388c = builder.f2390c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
    }

    public static Person fromAndroidPerson(android.app.Person person) {
        return new Builder().setName(person.getName()).setIcon(person.getIcon() != null ? IconCompat.createFromIcon(person.getIcon()) : null).setUri(person.getUri()).setKey(person.getKey()).setBot(person.isBot()).setImportant(person.isImportant()).build();
    }

    public static Person fromBundle(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("icon");
        return new Builder().setName(bundle.getCharSequence("name")).setIcon(bundle2 != null ? IconCompat.createFromBundle(bundle2) : null).setUri(bundle.getString("uri")).setKey(bundle.getString("key")).setBot(bundle.getBoolean("isBot")).setImportant(bundle.getBoolean("isImportant")).build();
    }

    public static Person fromPersistableBundle(PersistableBundle persistableBundle) {
        return new Builder().setName(persistableBundle.getString("name")).setUri(persistableBundle.getString("uri")).setKey(persistableBundle.getString("key")).setBot(persistableBundle.getBoolean("isBot")).setImportant(persistableBundle.getBoolean("isImportant")).build();
    }

    public IconCompat getIcon() {
        return this.b;
    }

    public String getKey() {
        return this.d;
    }

    public CharSequence getName() {
        return this.f2387a;
    }

    public String getUri() {
        return this.f2388c;
    }

    public boolean isBot() {
        return this.e;
    }

    public boolean isImportant() {
        return this.f;
    }

    public String resolveToLegacyUri() {
        String str = this.f2388c;
        if (str != null) {
            return str;
        }
        if (this.f2387a != null) {
            return "name:" + ((Object) this.f2387a);
        }
        return "";
    }

    public android.app.Person toAndroidPerson() {
        return new Person.Builder().setName(getName()).setIcon(getIcon() != null ? getIcon().toIcon() : null).setUri(getUri()).setKey(getKey()).setBot(isBot()).setImportant(isImportant()).build();
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f2387a);
        IconCompat iconCompat = this.b;
        bundle.putBundle("icon", iconCompat != null ? iconCompat.toBundle() : null);
        bundle.putString("uri", this.f2388c);
        bundle.putString("key", this.d);
        bundle.putBoolean("isBot", this.e);
        bundle.putBoolean("isImportant", this.f);
        return bundle;
    }

    public PersistableBundle toPersistableBundle() {
        PersistableBundle persistableBundle = new PersistableBundle();
        CharSequence charSequence = this.f2387a;
        persistableBundle.putString("name", charSequence != null ? charSequence.toString() : null);
        persistableBundle.putString("uri", this.f2388c);
        persistableBundle.putString("key", this.d);
        persistableBundle.putBoolean("isBot", this.e);
        persistableBundle.putBoolean("isImportant", this.f);
        return persistableBundle;
    }
}
