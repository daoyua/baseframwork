package module.base.baseframwork.untils;

import android.app.Activity;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



public class LogUtils {
    private LogUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static boolean logSwitch = true;
    private static boolean log2FileSwitch = false;
    private static char logFilter = 'v';
    private static String tag = "MyError:";
    private static String dir = null;

    /**
     * 初始化函数 * <p>与{@link #getBuilder()}两者选其一</p> * *
     * @param logSwitch 日志总开关 * @param log2FileSwitch 日志写入文件开关，
     *                  设为true需添加权限
     *                  {@code <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>} *
     *                  @param logFilter 输入日志类型有{@code v, d, i, w, e}<br>v代表输出所有信息，w则只输出警告... *
     *                  @param tag 标签
     */
//    public static void init(boolean logSwitch, boolean log2FileSwitch, char logFilter, String tag) {
//        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
//            dir = getContext().getExternalCacheDir().getPath() + File.separator;
//        } else {
//            dir = getContext().getCacheDir().getPath() + File.separator;
//        }
//        LogUtils.logSwitch = logSwitch;
//        LogUtils.log2FileSwitch = log2FileSwitch;
//        LogUtils.logFilter = logFilter;
//        LogUtils.tag = tag;
//    }

//    /**
//     * 获取LogUtils建造者 * <p>与{@link #init(boolean, boolean, char, String)}两者选其一</p> * * @return Builder对象
//     */
//    public static Builder getBuilder() {
//        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
//            dir = getContext().getExternalCacheDir().getPath() + File.separator + "log" + File.separator;
//        } else {
//            dir = getContext().getCacheDir().getPath() + File.separator + "log" + File.separator;
//        }
//        return new Builder();
//    }

    public static class Builder {
        private boolean logSwitch = true;
        private boolean log2FileSwitch = false;
        private char logFilter = 'v';
        private String tag = "TAG";

        public Builder setLogSwitch(boolean logSwitch) {
            this.logSwitch = logSwitch;
            return this;
        }

        public Builder setLog2FileSwitch(boolean log2FileSwitch) {
            this.log2FileSwitch = log2FileSwitch;
            return this;
        }

        public Builder setLogFilter(char logFilter) {
            this.logFilter = logFilter;
            return this;
        }

        public Builder setTag(String tag) {
            this.tag = tag;
            return this;
        }

        public void create() {
            LogUtils.logSwitch = logSwitch;
            LogUtils.log2FileSwitch = log2FileSwitch;
            LogUtils.logFilter = logFilter;
            LogUtils.tag = tag;
        }
    }

    /**
     * Verbose日志 * * @param msg 消息
     */
    public static void v(Object msg) {
        log(tag, msg.toString(), null, 'i');
    }

    /**
     * Verbose日志 * * @param tag 标签 * @param msg 消息
     */
    public static void v(String tag, Object msg) {
        log(tag, msg.toString(), null, 'i');
    }

    /**
     * Verbose日志 * * @param tag 标签 * @param msg 消息 * @param tr 异常
     */
    public static void v(String tag, Object msg, Throwable tr) {
        log(tag, msg.toString(), tr, 'v');
    }

    /**
     * Debug日志 * * @param msg 消息
     */
    public static void d(Object msg) {
        log(tag, msg.toString(), null, 'd');
    }

    /**
     * Debug日志 * * @param tag 标签 * @param msg 消息
     */
    public static void d(String tag, Object msg) {
        log(tag, msg.toString(), null, 'd');
    }

    /**
     * Debug日志 * * @param tag 标签 * @param msg 消息 * @param tr 异常
     */
    public static void d(String tag, Object msg, Throwable tr) {
        log(tag, msg.toString(), tr, 'd');
    }

    /**
     * Info日志 * * @param msg 消息
     */
    public static void i(Object msg) {
        log(tag, msg.toString(), null, 'i');
    }

    /**
     * Info日志 * * @param tag 标签 * @param msg 消息
     */
    public static void i(String tag, Object msg) {
        log(tag, msg.toString(), null, 'i');
    }

    /**
     * Info日志 * * @param tag 标签 * @param msg 消息 * @param tr 异常
     */
    public static void i(String tag, Object msg, Throwable tr) {
        log(tag, msg.toString(), tr, 'i');
    }

    /**
     * Warn日志 * * @param msg 消息
     */
    public static void w(Object msg) {
        log(tag, msg.toString(), null, 'w');
    }

    /**
     * Warn日志 * * @param tag 标签 * @param msg 消息
     */
    public static void w(String tag, Object msg) {
        log(tag, msg.toString(), null, 'w');
    }

    /**
     * Warn日志 * * @param tag 标签 * @param msg 消息 * @param tr 异常
     */
    public static void w(String tag, Object msg, Throwable tr) {
        log(tag, msg.toString(), tr, 'w');
    }

    /**
     * Error日志 * * @param msg 消息
     */
    public static void e(Object msg) {
        log(tag, msg.toString()+getThreadName(),null, 'e');
    }
    public static void e(Object msg,int i) {
        log(tag, msg.toString()+getThreadName(i), null, 'e');
    }
    /**
     * Error日志 * * @param msg 消息
     */
    public static void e(String msg,String threadInfo) {
        log(tag, msg+threadInfo, null, 'e');
    }

    /**
     * Error日志 * * @param tag 标签 * @param msg 消息
     */
    public static void e(String tag, Object msg) {
        log(tag, msg.toString(), null, 'e');
    }

    /**
     * Error日志 * * @param tag 标签 * @param msg 消息 * @param tr 异常
     */
    public static void e(String tag, Object msg, Throwable tr) {
        log(tag, msg.toString(), tr, 'e');
    }

    /**
     * 根据tag, msg和等级，输出日志 * * @param tag 标签 * @param msg 消息 * @param tr 异常 * @param type 日志类型
     */
    private static void log(String tag, String msg, Throwable tr, char type) {
        if (logSwitch) {
            if ('e' == type && ('e' == logFilter || 'v' == logFilter)) {
                Log.e(generateTag(tag), msg, tr);
            } else if ('w' == type && ('w' == logFilter || 'v' == logFilter)) {
                Log.w(generateTag(tag), msg, tr);
            } else if ('d' == type && ('d' == logFilter || 'v' == logFilter)) {
                Log.d(generateTag(tag), msg, tr);
            } else if ('i' == type && ('d' == logFilter || 'v' == logFilter)) {
                Log.i(generateTag(tag), msg, tr);
            }
            if (log2FileSwitch) {
                log2File(type, generateTag(tag), msg + '\n' + Log.getStackTraceString(tr));
            }
        }
    }

    /**
     * 打开日志文件并写入日志 * * @param type 日志类型 * @param tag 标签 * @param content 内容
     **/
    private synchronized static void log2File(final char type, final String tag, final String content) {

        if (content == null) return;
        Date now = new Date();
        String date = new SimpleDateFormat("MM-dd", Locale.getDefault()).format(now);
        final String fullPath = dir + date + ".txt";
       File file= new File (fullPath);
        if (!file.exists()) return;
        String time = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(now);
        final String dateLogContent = time + ":" + type + ":" + tag + ":" + content + '\n';
        e("输出日志到文件"+fullPath+dateLogContent);
        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedWriter bw = null;
                try {
                    bw = new BufferedWriter(new FileWriter(fullPath, true));
                    bw.write(dateLogContent);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
//                    CloseUtils.closeIO(bw);
                    try {
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     * 产生tag * * @return tag
     */
    private static String generateTag(String tag) {

        return "打印信息" ;
    }
    /**
     * 得到调用此方法的线程的线程名
     *0，当前，1调用，3 current
     * @return
     */
    public static String getThreadName() {
        StringBuffer sb = new StringBuffer();
        Thread thread = Thread.currentThread();
        StackTraceElement stackTraceElement = thread.getStackTrace()[4];

        sb.append(" from: class["+stackTraceElement.getClassName()+"]  line:");
        sb.append(stackTraceElement.getLineNumber()+"");
        sb.append("  method[");
        sb.append(stackTraceElement.getMethodName()+"()]\n");
        sb.append(" thread->"+thread.getName());
//        sb.append("\n**");
        return sb.toString();
    }

    /**
     *  initview() thread->main class[java.lang.Thread]-> getStackTrace() 1536:
     * initview() thread->main class[module.base.baseframwork.untils.LogUtils]-> getThreadName() 280:
     *  initview() thread->main class[module.base.baseframwork.base.activity.BaseActivity]-> mylog() 56:
     *  initview() thread->main class[module.base.baseframwork.base.activity.BaseActivity]-> onCreate() 50:
     *  initview()thread->main class[module.base.baseframwork.base.activity.BaseActivityMVP]-> onCreate() 17:
     * @return
     */
    public static String getThreadName(int i) {
        StringBuffer sb = new StringBuffer();
        Thread thread = Thread.currentThread();
        StackTraceElement stackTraceElement = thread.getStackTrace()[i];

        sb.append(" from: class["+stackTraceElement.getClassName()+"]  line:");
        sb.append(stackTraceElement.getLineNumber()+"");
        sb.append("  method[");
        sb.append(stackTraceElement.getMethodName()+"()]\n");
        sb.append(" thread->"+thread.getName());

        return sb.toString();
    }
}



