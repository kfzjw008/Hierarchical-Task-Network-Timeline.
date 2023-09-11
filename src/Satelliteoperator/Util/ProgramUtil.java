package Satelliteoperator.Util;

/**
 * @program: JSHOP2
 * @description: 程序运行相关工具库
 * @author: kfzjw008(Junwei Zhang)
 * @create: 2023-09-12 00:38
 **/
public class ProgramUtil {

    public static void timeExample () throws InterruptedException {
        // 开始时间
        long stime = System.currentTimeMillis();
        // 执行时间（1s）
        //Thread.sleep(1000);
        // 结束时间
        long etime = System.currentTimeMillis();
        // 计算执行时间
        System.out.printf("执行时长：%d 毫秒.", (etime - stime));

    }
}
