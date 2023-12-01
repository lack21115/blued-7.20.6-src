package java.util;

import java.io.Serializable;
import libcore.icu.ICU;
import libcore.icu.LocaleData;

/* loaded from: source-2895416-dex2jar.jar:java/util/Currency.class */
public final class Currency implements Serializable {
    private static final HashMap<String, Currency> codesToCurrencies = new HashMap<>();
    private static final HashMap<Locale, Currency> localesToCurrencies = new HashMap<>();
    private static final long serialVersionUID = -158308464356906721L;
    private final String currencyCode;

    private Currency(String str) {
        this.currencyCode = str;
        if (ICU.getCurrencySymbol(Locale.US, str) == null) {
            throw new IllegalArgumentException("Unsupported ISO 4217 currency code: " + str);
        }
    }

    public static Set<Currency> getAvailableCurrencies() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        String[] availableCurrencyCodes = ICU.getAvailableCurrencyCodes();
        int length = availableCurrencyCodes.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return linkedHashSet;
            }
            linkedHashSet.add(getInstance(availableCurrencyCodes[i2]));
            i = i2 + 1;
        }
    }

    public static Currency getInstance(String str) {
        Currency currency;
        synchronized (codesToCurrencies) {
            Currency currency2 = codesToCurrencies.get(str);
            currency = currency2;
            if (currency2 == null) {
                currency = new Currency(str);
                codesToCurrencies.put(str, currency);
            }
        }
        return currency;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
        if (r0.equals("PREEURO") != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Currency getInstance(java.util.Locale r5) {
        /*
            java.util.HashMap<java.util.Locale, java.util.Currency> r0 = java.util.Currency.localesToCurrencies
            r8 = r0
            r0 = r8
            monitor-enter(r0)
            r0 = r5
            if (r0 != 0) goto L19
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> L14
            r1 = r0
            java.lang.String r2 = "locale == null"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L14
            throw r0     // Catch: java.lang.Throwable -> L14
        L14:
            r5 = move-exception
            r0 = r8
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            r0 = r5
            throw r0
        L19:
            java.util.HashMap<java.util.Locale, java.util.Currency> r0 = java.util.Currency.localesToCurrencies     // Catch: java.lang.Throwable -> L14
            r1 = r5
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L14
            java.util.Currency r0 = (java.util.Currency) r0     // Catch: java.lang.Throwable -> L14
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L2c
            r0 = r8
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            r0 = r6
            return r0
        L2c:
            r0 = r5
            java.lang.String r0 = r0.getCountry()     // Catch: java.lang.Throwable -> L14
            r7 = r0
            r0 = r5
            java.lang.String r0 = r0.getVariant()     // Catch: java.lang.Throwable -> L14
            r9 = r0
            r0 = r7
            r6 = r0
            r0 = r9
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L14
            if (r0 != 0) goto L7a
            r0 = r9
            java.lang.String r1 = "EURO"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L14
            if (r0 != 0) goto L61
            r0 = r9
            java.lang.String r1 = "HK"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L14
            if (r0 != 0) goto L61
            r0 = r7
            r6 = r0
            r0 = r9
            java.lang.String r1 = "PREEURO"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L14
            if (r0 == 0) goto L7a
        L61:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L14 java.lang.Throwable -> L14
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L14
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L14
            java.lang.String r1 = "_"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L14
            r1 = r9
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L14
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L14
            r6 = r0
        L7a:
            r0 = r6
            java.lang.String r0 = libcore.icu.ICU.getCurrencyCode(r0)     // Catch: java.lang.Throwable -> L14
            r6 = r0
            r0 = r6
            if (r0 != 0) goto L9e
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L14
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L14
            r3 = r2
            r3.<init>()     // Catch: java.lang.Throwable -> L14
            java.lang.String r3 = "Unsupported ISO 3166 country: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L14
            r3 = r5
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L14
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L14
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L14
            throw r0     // Catch: java.lang.Throwable -> L14
        L9e:
            r0 = r6
            java.lang.String r1 = "XXX"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L14
            if (r0 == 0) goto Lab
            r0 = r8
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            r0 = 0
            return r0
        Lab:
            r0 = r6
            java.util.Currency r0 = getInstance(r0)     // Catch: java.lang.Throwable -> L14
            r6 = r0
            java.util.HashMap<java.util.Locale, java.util.Currency> r0 = java.util.Currency.localesToCurrencies     // Catch: java.lang.Throwable -> L14
            r1 = r5
            r2 = r6
            java.lang.Object r0 = r0.put(r1, r2)     // Catch: java.lang.Throwable -> L14
            r0 = r8
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Currency.getInstance(java.util.Locale):java.util.Currency");
    }

    private Object readResolve() {
        return getInstance(this.currencyCode);
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public int getDefaultFractionDigits() {
        if (this.currencyCode.equals("XXX")) {
            return -1;
        }
        return ICU.getCurrencyFractionDigits(this.currencyCode);
    }

    public String getDisplayName() {
        return getDisplayName(Locale.getDefault());
    }

    public String getDisplayName(Locale locale) {
        return ICU.getCurrencyDisplayName(locale, this.currencyCode);
    }

    public String getSymbol() {
        return getSymbol(Locale.getDefault());
    }

    public String getSymbol(Locale locale) {
        String str;
        if (locale == null) {
            throw new NullPointerException("locale == null");
        }
        LocaleData localeData = LocaleData.get(locale);
        if (localeData.internationalCurrencySymbol.equals(this.currencyCode)) {
            str = localeData.currencySymbol;
        } else {
            String currencySymbol = ICU.getCurrencySymbol(locale, this.currencyCode);
            str = currencySymbol;
            if (currencySymbol == null) {
                return this.currencyCode;
            }
        }
        return str;
    }

    public String toString() {
        return this.currencyCode;
    }
}
