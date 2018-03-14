package com.test.tabmarvelcomicscodingtest.utilities

import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.digest.DigestUtils

/**
 * @author Filippo Engidashet [filippo.eng>@gmail.com]
 * @version 1.0.0
 * @since Saturday, 10/03/2018 at 16:10.
 */

object CryptoUtils {

    fun md5Digest(toHash: String): String {
        return String(Hex.encodeHex(DigestUtils.md5(toHash)))
    }
}
