package com.dawn.one.utilities

import android.text.TextUtils
import android.util.Log
import timber.log.Timber


/**
 * 由于java和kotlin的stackTrace不同
 * java使用 GiantLog.jd();
 * kotlin使用 GiantLog.d()
 */
class Zxlog {

    companion object {

        private const val DEFAULT_MESSAGE = "execute"
        const val TAG_DEFAULT = "zxlog"
        private const val NULL_TIPS = "Log`s object is null"
        private const val PRINT_TYPE_KOTLIN = 1
        private const val PRINT_TYPE_JAVA = 2
        private const val STACK_TRACE_INDEX_KOTLIN = 5
        private const val STACK_TRACE_INDEX_JAVA = 6

        private var mIsGlobalTagEmpty = true
        private var TAG: String = TAG_DEFAULT
        private var LEVEL = Log.VERBOSE

        @JvmStatic
        fun init(
            tag: String = TAG_DEFAULT,
            isShowLog: Boolean = true,
            level: Int = Log.VERBOSE
        ) {
            TAG = tag
            LEVEL = level
            mIsGlobalTagEmpty = TextUtils.isEmpty(TAG)
            if (isShowLog) {
                Timber.plant(Timber.DebugTree())
            } else {
                Timber.plant(ReleaseTree())
            }
        }

        /***************** kotlin *********************/
        /**
         * V verbose
         */
        fun v() {
            printLog(Log.VERBOSE, null, DEFAULT_MESSAGE, STACK_TRACE_INDEX_KOTLIN)
        }

        fun v(verbose: Any?) {
            printLog(Log.VERBOSE, null, verbose, STACK_TRACE_INDEX_KOTLIN)
        }

        fun v(tag: String, verbose: Any?) {
            printLog(Log.VERBOSE, tag, verbose, STACK_TRACE_INDEX_KOTLIN)
        }

        /**
         * D debug
         */
        fun d() {
            printLog(Log.DEBUG, null, DEFAULT_MESSAGE, STACK_TRACE_INDEX_KOTLIN)
        }

        fun d(debug: Any?) {
            printLog(Log.DEBUG, null, debug, STACK_TRACE_INDEX_KOTLIN)
        }

        fun d(tag: String, debug: Any?) {
            printLog(Log.DEBUG, tag, debug, STACK_TRACE_INDEX_KOTLIN)
        }

        /**
         * I information
         */
        fun i() {
            printLog(Log.INFO, null, DEFAULT_MESSAGE, STACK_TRACE_INDEX_KOTLIN)
        }

        fun i(information: Any?) {
            printLog(Log.INFO, null, information, STACK_TRACE_INDEX_KOTLIN)
        }

        fun i(tag: String, information: Any?) {
            printLog(Log.INFO, tag, information, STACK_TRACE_INDEX_KOTLIN)
        }

        /**
         * W warning
         */
        fun w() {
            printLog(Log.WARN, null, DEFAULT_MESSAGE, STACK_TRACE_INDEX_KOTLIN)
        }

        fun w(warning: Any?) {
            printLog(Log.WARN, null, warning, STACK_TRACE_INDEX_KOTLIN)
        }

        fun w(tag: String, warning: Any?) {
            printLog(Log.WARN, tag, warning, STACK_TRACE_INDEX_KOTLIN)
        }

        /**
         * e error
         */
        fun e() {
            printLog(Log.ERROR, null, DEFAULT_MESSAGE, STACK_TRACE_INDEX_KOTLIN)
        }

        fun e(error: Any?) {
            printLog(Log.ERROR, null, error, STACK_TRACE_INDEX_KOTLIN)
        }

        fun e(tag: String, error: Any?) {
            printLog(
                Log.ERROR, tag, error, STACK_TRACE_INDEX_KOTLIN
            )
        }

        fun e(t: Throwable?) {
            printLog(Log.ERROR, null, t?.toString(),STACK_TRACE_INDEX_KOTLIN)
            Timber.e(t)
        }

        /***************** java *********************/
        /**
         * V verbose
         */
        @JvmStatic
        fun jv() {
            printLog(Log.VERBOSE, null, DEFAULT_MESSAGE, STACK_TRACE_INDEX_JAVA)
        }

        @JvmStatic
        fun jv(verbose: Any?) {
            printLog(Log.VERBOSE, null, verbose, STACK_TRACE_INDEX_JAVA)
        }

        @JvmStatic
        fun jv(tag: String, verbose: Any?) {
            printLog(Log.VERBOSE, tag, verbose, STACK_TRACE_INDEX_JAVA)
        }

        /**
         * D debug
         */
        @JvmStatic
        fun jd() {
            printLog(Log.DEBUG, null, DEFAULT_MESSAGE, STACK_TRACE_INDEX_JAVA)
        }

        @JvmStatic
        fun jd(debug: Any?) {
            printLog(Log.DEBUG, null, debug, STACK_TRACE_INDEX_JAVA)
        }

        @JvmStatic
        fun jd(tag: String, debug: Any?) {
            printLog(Log.DEBUG, tag, debug, STACK_TRACE_INDEX_JAVA)
        }

        /**
         * I information
         */
        @JvmStatic
        fun ji() {
            printLog(Log.INFO, null, DEFAULT_MESSAGE, STACK_TRACE_INDEX_JAVA)
        }

        @JvmStatic
        fun ji(information: Any?) {
            printLog(Log.INFO, null, information, STACK_TRACE_INDEX_JAVA)
        }

        @JvmStatic
        fun ji(tag: String, information: Any?) {
            printLog(Log.INFO, tag, information, STACK_TRACE_INDEX_JAVA)
        }

        /**
         * W warning
         */
        @JvmStatic
        fun jw() {
            printLog(Log.WARN, null, DEFAULT_MESSAGE, STACK_TRACE_INDEX_JAVA)
        }

        @JvmStatic
        fun jw(warning: Any?) {
            printLog(Log.WARN, null, warning, STACK_TRACE_INDEX_JAVA)
        }

        @JvmStatic
        fun jw(tag: String, warning: Any?) {
            printLog(Log.WARN, tag, warning, STACK_TRACE_INDEX_JAVA)
        }

        /**
         * e error
         */
        @JvmStatic
        fun je() {
            printLog(Log.ERROR, null, DEFAULT_MESSAGE, STACK_TRACE_INDEX_JAVA)
        }

        @JvmStatic
        fun je(error: Any?) {
            printLog(Log.ERROR, null, error, STACK_TRACE_INDEX_JAVA)
        }

        @JvmStatic
        fun je(tag: String, error: Any?) {
            printLog(
                Log.ERROR, tag, error, STACK_TRACE_INDEX_JAVA
            )
        }

        @JvmStatic
        fun je(t: Throwable?) {
            printLog(Log.ERROR, null, t?.toString(),STACK_TRACE_INDEX_JAVA)
            Timber.e(t)
        }


        private fun printLog(level: Int, tagStr: String?, any: Any?, stackTraceIndex: Int) {
            if (LEVEL > level) {
                return
            }
            val contents = wrapperContent(tagStr, any, stackTraceIndex)
            val tag = contents[0]
            val msg = contents[1]
            val headString = contents[2]
            toPrint(level, tag, headString + msg)
        }

        /**
         * @param tagStr 用户自定义的tag
         * @param any 用户输出的文字
         * @return
         */
        private fun wrapperContent(tagStr: String?, any: Any?, stackTraceIndex: Int): Array<String> {
            val stackTrace = Thread.currentThread().stackTrace
            val targetElement = stackTrace[stackTraceIndex]
            val fileName = targetElement.fileName

            val methodName = targetElement.methodName
            var lineNumber = targetElement.lineNumber
            if (lineNumber < 0) {
                lineNumber = 0
            }

            val tag: String = tagStr ?: if (mIsGlobalTagEmpty) {
                TAG_DEFAULT
            } else {
                TAG
            }

            val msg = if (any == null) NULL_TIPS else getObjectsString(any)

            val headString = "[ ($fileName:$lineNumber)=>$methodName ] "
            return arrayOf(tag, msg, headString)
        }

        private fun getObjectsString(any: Any?): String {
            return any.toString()
        }

        private fun toPrint(level: Int, tag: String, msg: String) {
            var index = 0
            val maxLength = 2000
            val countOfSub = msg.length / maxLength
            if (countOfSub > 0) {
                for (i in 0 until countOfSub) {
                    val sub = msg.substring(index, index + maxLength)
                    printSub(level, tag, sub)
                    index += maxLength
                }
                printSub(level, tag, msg.substring(index))
            } else {
                printSub(level, tag, msg)
            }
        }

        private fun printSub(level: Int, tag: String, sub: String) {
            when (level) {
                Log.VERBOSE -> {
                    Timber.tag(tag).v(sub)
                }
                Log.DEBUG -> {
                    Timber.tag(tag).d(sub)
                }
                Log.INFO -> {
                    Timber.tag(tag).i(sub)
                }
                Log.WARN -> {
                    Timber.tag(tag).w(sub)
                }
                Log.ERROR -> {
                    Timber.tag(tag).e(sub)
                }
            }
        }
    }

}