package Satelliteoperator.Util;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * @program: JSHOP2
 * @description: 任务级指令相关操作Util
 * @author: kfzjw008(Junwei Zhang)
 * @create: 2023-09-06 10:01
 **/
public class TaskLevelUtil {
    //1字节=8比特=2位16进制数字
    //相关全局变量
    static ArrayList<String> TaskLevelRepository = new ArrayList<>();//任务级指令存储


    //任务级指令生成
    public static String taskLevelGenerate(String id, String parametersLength, String parameter) {
        String result = "";
        result = id;

        return "";
    }

    //任务级指令中的参数生成
    public static String parameterGenerate(String Type, String dataType, String length, String Value) {
        String result = "";
        return result;
    }

//通用参数校验（正则表达式）
    public static boolean isValidHexString(String input,String ValidType, String hexPattern) {
        // 使用正则表达式匹配规则
        if(ValidType.equals("1")) hexPattern = "^[0-9a-fA-F]{4}$";


        Pattern pattern = Pattern.compile(hexPattern);
        Matcher matcher = pattern.matcher(input);

        // 检查是否匹配
        return matcher.matches();
    }




}
