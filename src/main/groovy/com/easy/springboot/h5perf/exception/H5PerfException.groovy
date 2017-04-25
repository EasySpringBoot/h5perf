package com.easy.springboot.h5perf.exception

/**
 * Created by jack on 2017/4/24.
 */
class H5PerfException extends Exception {
    H5PerfException() {
        super()
    }

    H5PerfException(String message) {
        super(message)
    }

    H5PerfException(String message, Throwable cause) {
        super(message, cause)
    }

    H5PerfException(Throwable cause) {
        super(cause)
    }

    static String getStackMsg(Throwable e) {
        def result = new StringBuffer()
        StackTraceElement[] stackArray = e.getStackTrace()
        result.append(e.getClass().getName() + "\n")

        for (StackTraceElement element : stackArray) {
            result.append(element.toString() + "\n")
        }
        result.toString()
    }
}
