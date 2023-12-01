package org.apache.harmony.security.utils;

import java.security.Provider;
import java.security.Security;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.apache.harmony.security.fortress.Services;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/utils/AlgNameMapper.class */
public class AlgNameMapper {
    private static AlgNameMapperSource source = null;
    private static volatile int cacheVersion = -1;
    private static final String[] serviceName = {"Cipher", "AlgorithmParameters", "Signature"};
    private static final String[][] knownAlgMappings = {new String[]{"1.2.840.10040.4.1", "DSA"}, new String[]{"1.2.840.10040.4.3", "SHA1withDSA"}, new String[]{"1.2.840.113549.1.1.1", "RSA"}, new String[]{"1.2.840.113549.1.1.4", "MD5withRSA"}, new String[]{"1.2.840.113549.1.1.5", "SHA1withRSA"}, new String[]{"1.2.840.113549.1.3.1", "DiffieHellman"}, new String[]{"1.2.840.113549.1.5.3", "pbeWithMD5AndDES-CBC"}, new String[]{"1.2.840.113549.1.12.1.3", "pbeWithSHAAnd3-KeyTripleDES-CBC"}, new String[]{"1.2.840.113549.1.12.1.6", "pbeWithSHAAnd40BitRC2-CBC"}, new String[]{"1.2.840.113549.3.2", "RC2-CBC"}, new String[]{"1.2.840.113549.3.3", "RC2-EBC"}, new String[]{"1.2.840.113549.3.4", "RC4"}, new String[]{"1.2.840.113549.3.5", "RC4WithMAC"}, new String[]{"1.2.840.113549.3.6", "DESx-CBC"}, new String[]{"1.2.840.113549.3.7", "TripleDES-CBC"}, new String[]{"1.2.840.113549.3.8", "rc5CBC"}, new String[]{"1.2.840.113549.3.9", "RC5-CBC"}, new String[]{"1.2.840.113549.3.10", "DESCDMF"}, new String[]{"2.23.42.9.11.4.1", "ECDSA"}};
    private static final Map<String, String> alg2OidMap = new HashMap();
    private static final Map<String, String> oid2AlgMap = new HashMap();
    private static final Map<String, String> algAliasesMap = new HashMap();

    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.String[], java.lang.String[][]] */
    static {
        String[][] strArr = knownAlgMappings;
        if (strArr.length < 0) {
            String str = strArr[0][1];
            Locale locale = Locale.US;
            throw new VerifyError("bad dex opcode");
        }
    }

    private AlgNameMapper() {
    }

    private static void checkCacheVersion() {
        synchronized (AlgNameMapper.class) {
            try {
                int cacheVersion2 = Services.getCacheVersion();
                if (cacheVersion2 != cacheVersion) {
                    Provider[] providers = Security.getProviders();
                    int length = providers.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        selectEntries(providers[i2]);
                        i = i2 + 1;
                    }
                    cacheVersion = cacheVersion2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String getStandardName(String str) {
        return algAliasesMap.get(str.toUpperCase(Locale.US));
    }

    public static boolean isOID(String str) {
        return org.apache.harmony.security.asn1.ObjectIdentifier.isOID(normalize(str));
    }

    public static String map2AlgName(String str) {
        checkCacheVersion();
        String str2 = oid2AlgMap.get(str);
        if (str2 != null) {
            return algAliasesMap.get(str2);
        }
        AlgNameMapperSource algNameMapperSource = source;
        if (algNameMapperSource != null) {
            return algNameMapperSource.mapOidToName(str);
        }
        return null;
    }

    public static String map2OID(String str) {
        checkCacheVersion();
        String str2 = alg2OidMap.get(str.toUpperCase(Locale.US));
        if (str2 != null) {
            return str2;
        }
        AlgNameMapperSource algNameMapperSource = source;
        if (algNameMapperSource != null) {
            return algNameMapperSource.mapNameToOid(str);
        }
        return null;
    }

    public static String normalize(String str) {
        String str2 = str;
        if (str.startsWith("OID.")) {
            str2 = str.substring(4);
        }
        return str2;
    }

    private static void selectEntries(Provider provider) {
        String[] strArr;
        Set<Map.Entry<Object, Object>> entrySet = provider.entrySet();
        int length = serviceName.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str = "Alg.Alias." + strArr[i2] + ".";
            for (Map.Entry<Object, Object> entry : entrySet) {
                String str2 = (String) entry.getKey();
                if (str2.startsWith(str)) {
                    String substring = str2.substring(str.length());
                    String str3 = (String) entry.getValue();
                    String upperCase = str3.toUpperCase(Locale.US);
                    if (isOID(substring)) {
                        String str4 = substring;
                        if (substring.startsWith("OID.")) {
                            str4 = substring.substring(4);
                        }
                        boolean containsKey = oid2AlgMap.containsKey(str4);
                        boolean containsKey2 = alg2OidMap.containsKey(upperCase);
                        if (!containsKey || !containsKey2) {
                            if (!containsKey) {
                                oid2AlgMap.put(str4, upperCase);
                            }
                            if (!containsKey2) {
                                alg2OidMap.put(upperCase, str4);
                            }
                            algAliasesMap.put(upperCase, str3);
                        }
                    } else if (!algAliasesMap.containsKey(substring.toUpperCase(Locale.US))) {
                        algAliasesMap.put(substring.toUpperCase(Locale.US), str3);
                    }
                }
            }
            i = i2 + 1;
        }
    }

    public static void setSource(AlgNameMapperSource algNameMapperSource) {
        source = algNameMapperSource;
    }
}
