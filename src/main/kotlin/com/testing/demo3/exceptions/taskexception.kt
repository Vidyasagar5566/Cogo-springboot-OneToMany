package com.testing.demo3.exceptions

import java.lang.Exception

internal class TaskException(override val message: String?) : Exception(message) {
}