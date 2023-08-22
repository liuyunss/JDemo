package com.jdemo.transfor;

import com.cennavi.ps.common.codec.RSAUtil;
import org.apache.commons.codec.binary.Base64;


/**
 * 类描述.
 *
 * @author SKIES
 * @date 2023-04-07 18:25
 */
public class StringToDate {
    public static void main(String[] args) {
        try {
            System.out.println(RSAUtil.encryptByPublicKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC65mqn0K4IC9MjiUQdFo1QguT0aiYhjCqPh7h7o2WQy7Z7PuJAEFsa6RE58MfW060+bIovOEgAGgJzM2R+BEDHoMeOpjvx8hhAIW2Xh+DEpE3G3aHzzUPJ7S7sWLABTfILKB7D6kxzOc7H/5RLuD9FFZnYq29jHDA642aEBjwzXQIDAQAB","gongan@110"));
//            System.out.println(RSAUtil.decryptByPrivateKey("MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALrmaqfQrggL0yOJRB0WjVCC5PRqJiGMKo+HuHujZZDLtns+4kAQWxrpETnwx9bTrT5sii84SAAaAnMzZH4EQMegx46mO/HyGEAhbZeH4MSkTcbdofPNQ8ntLuxYsAFN8gsoHsPqTHM5zsf/lEu4P0UVmdirb2McMDrjZoQGPDNdAgMBAAECgYAcFPjbhCBR9yzfPwWr9TKAcVpjWvuluMDAVh0i/pcJHYKqm/U0uQBnV7ON6B6uqZlzMq3EkIlI8p+BnawwvwTYd/LypqeecTEye3dtmqQklPQ/eQA+R7G8mR1GcFwW1p298w/IqIQPnQfiGKIZMMywYoGBhuhf3ej5UjeYzu1EAQJBAOkyMCq92DZXHMXE1qCskiA+xKLdHplQdKso6Pw+YBGTrSqroP3vWv88nJtY3z8kipfipJnTumLvh1VdLl489l0CQQDNLUInuIPV0Eb71XEdO9xh+uAWiQ6A7fGjahcTsDowNmt87HmriFNYZ0u+zaPF4QI2vpylpFJ7TeBRaWvy3mEBAkEApMkRXnKu4Z9nNp2k6P9pdx3DyC6m28IN35FWKkFNk74eRSPo7OiCDhDfvarsfussgK3okMccU6Ndp8Xj6TX9BQJAFYbWFgzJ6Dj9+ZYfVA3fxXfo4vRmTSip3ZdX7Hzk3gIXrPeynEilVfUggVhaAnzlGpFNJiPjc4RsMJ568PRcAQJAKVYxp7YkpkHN6dEcHIUh9XFpGJpiRpcDDS6p8rKESytYWAkj08povjSFfKt6H2SqeF6EAB0qW3v9nXXLnG7Beg==",
//                    "SzDt24hkkpu8BKpEOhg5CyBUKEv8X6g6DwCpCDsytAvQETesDSca5TpRrWTEpE7NwWPTbfhvGsKkia3d6kT9ClAR6BfsDGKnUqhNy1teuoVkyolOs0dkgyoKlOZKeFmL08lB817lf8LdbE7dEj4HNNe6yJAcPu4iws1eOLawGMQ="));
            System.out.println(Base64.decodeBase64("a"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
