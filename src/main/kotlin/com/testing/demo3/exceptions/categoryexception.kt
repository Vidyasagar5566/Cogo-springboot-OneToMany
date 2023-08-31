package com.testing.demo3.exceptions

import java.lang.Exception

internal class CategoryException(override val message: String?) : Exception(message) {
}