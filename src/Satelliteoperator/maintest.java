package Satelliteoperator;

import Satelliteoperator.tableclass.TaskInformation;

import java.io.IOException;
import java.util.ArrayList;

import static Satelliteoperator.htnutil.*;
import static Satelliteoperator.hugnjing.huanjing1T1;

/**
 * @program: JSHOP2
 * @description: 主测试类
 * @author: kfzjw008(Junwei Zhang)
 * @create: 2023-08-27 19:08
 **/

public class maintest {
    //规划模拟器
    public static String ADDRESS_FILE_MAKE = "D:\\研究生\\学习\\研究内容\\【1】任务规划-HTN解决任务调度【主课题】\\202303\\源码\\JSHOP2_1.0.3\\JSHOP2\\bin\\PROBLEM";
    public static ArrayList<String> TaskLevelRepository = new ArrayList<>();//任务级指令存储
    public static ArrayList<TaskInformation> taskInformationTable = new ArrayList<>();
    public static ArrayList<ArrayList<String>> Timeline=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //0环境配置
        taskInformationTable= huanjing1T1();

        //1首先基于任务级指令生成problem文件
        //2其次基于航天器现有资源生成domain文件
        //3调用排序（已完成，见下）


        //生成problem文件
        //  writefile("default"," (defproblem problem basic((have kiwi))((swap banjo kiwi)))","problem");
        //生成domain文件
        // writefile("default","(defdomain basic ((:operator (!pickup ?a) () () ((have ?a)))(:operator (!drop ?a) ((have ?a)) ((have ?a)) ())(:method (swap ?x ?y)((have ?x) (not (have ?y)))((!drop ?x) (!pickup ?y))((have ?y) (not (have ?x)))((!drop ?y) (!pickup ?x)))))","domain");
        //生成make文件
        createbat("problem", "domain_satellite", "default");

        String result = runCmd(ADDRESS_FILE_MAKE, "make");

        //4解析排序结果，执行时间线操作。
        //4.1分割
        TaskLevelRepository = timelinesplit(result);
//4.2排序


        //5执行资源冲突消解操作
        //6输出规划结果
    }


}
