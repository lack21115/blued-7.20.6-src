package com.google.zxing.client.result;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/client/result/AddressBookParsedResult.class */
public final class AddressBookParsedResult extends ParsedResult {
    private final String[] addressTypes;
    private final String[] addresses;
    private final String birthday;
    private final String[] emailTypes;
    private final String[] emails;
    private final String[] geo;
    private final String instantMessenger;
    private final String[] names;
    private final String[] nicknames;
    private final String note;
    private final String org;
    private final String[] phoneNumbers;
    private final String[] phoneTypes;
    private final String pronunciation;
    private final String title;
    private final String[] urls;

    public AddressBookParsedResult(String[] strArr, String[] strArr2, String str, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String str2, String str3, String[] strArr7, String[] strArr8, String str4, String str5, String str6, String[] strArr9, String[] strArr10) {
        super(ParsedResultType.ADDRESSBOOK);
        if (strArr3 != null && strArr4 != null && strArr3.length != strArr4.length) {
            throw new IllegalArgumentException("Phone numbers and types lengths differ");
        }
        if (strArr5 != null && strArr6 != null && strArr5.length != strArr6.length) {
            throw new IllegalArgumentException("Emails and types lengths differ");
        }
        if (strArr7 != null && strArr8 != null && strArr7.length != strArr8.length) {
            throw new IllegalArgumentException("Addresses and types lengths differ");
        }
        this.names = strArr;
        this.nicknames = strArr2;
        this.pronunciation = str;
        this.phoneNumbers = strArr3;
        this.phoneTypes = strArr4;
        this.emails = strArr5;
        this.emailTypes = strArr6;
        this.instantMessenger = str2;
        this.note = str3;
        this.addresses = strArr7;
        this.addressTypes = strArr8;
        this.org = str4;
        this.birthday = str5;
        this.title = str6;
        this.urls = strArr9;
        this.geo = strArr10;
    }

    public AddressBookParsedResult(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String[] strArr7) {
        this(strArr, null, null, strArr2, strArr3, strArr4, strArr5, null, null, strArr6, strArr7, null, null, null, null, null);
    }

    public String[] getAddressTypes() {
        return this.addressTypes;
    }

    public String[] getAddresses() {
        return this.addresses;
    }

    public String getBirthday() {
        return this.birthday;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder sb = new StringBuilder(100);
        maybeAppend(this.names, sb);
        maybeAppend(this.nicknames, sb);
        maybeAppend(this.pronunciation, sb);
        maybeAppend(this.title, sb);
        maybeAppend(this.org, sb);
        maybeAppend(this.addresses, sb);
        maybeAppend(this.phoneNumbers, sb);
        maybeAppend(this.emails, sb);
        maybeAppend(this.instantMessenger, sb);
        maybeAppend(this.urls, sb);
        maybeAppend(this.birthday, sb);
        maybeAppend(this.geo, sb);
        maybeAppend(this.note, sb);
        return sb.toString();
    }

    public String[] getEmailTypes() {
        return this.emailTypes;
    }

    public String[] getEmails() {
        return this.emails;
    }

    public String[] getGeo() {
        return this.geo;
    }

    public String getInstantMessenger() {
        return this.instantMessenger;
    }

    public String[] getNames() {
        return this.names;
    }

    public String[] getNicknames() {
        return this.nicknames;
    }

    public String getNote() {
        return this.note;
    }

    public String getOrg() {
        return this.org;
    }

    public String[] getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public String[] getPhoneTypes() {
        return this.phoneTypes;
    }

    public String getPronunciation() {
        return this.pronunciation;
    }

    public String getTitle() {
        return this.title;
    }

    public String[] getURLs() {
        return this.urls;
    }
}
