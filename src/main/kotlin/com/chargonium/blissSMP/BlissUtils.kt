package com.chargonium.blissSMP

import java.security.MessageDigest

class BlissUtils {
    fun generateCustomModelData(identifier: String): Int {
        val hash = MessageDigest.getInstance("SHA-256").digest(identifier.toByteArray())
        val hashString = hash.joinToString("") { String.format("%02x", it) }

        return hashString.substring(0, 6).toInt(16)
    }
}