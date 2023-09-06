package Satelliteoperator;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @program: JSHOP2
 * @description: 生成文件
 * @author: kfzjw008(Junwei Zhang)
 * @create: 2023-08-27 18:59
 **/
public class htnutil {


    // 输入 path：Problem文件的生成地点	content：Problem文件的内容
    public static void writefile(String path, String content,String type) throws IOException {
        if(type.equals("problem")){
            try {
                if(path.equals("default"))
                    path="./bin/PROBLEM/problem";
                File file = new File(path); // 不指定新建文件类型，即可生成“文件”类型给JSHOP2调用。
                OutputStream out = new FileOutputStream(file);
                BufferedWriter rd = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
                rd.write(content);
                rd.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }if(type.equals("domain")){
            try {
                if(path.equals("default"))
                    path="./bin/PROBLEM/domain_satellite";
                File file = new File(path); // 不指定新建文件类型，即可生成“文件”类型给JSHOP2调用。
                OutputStream out = new FileOutputStream(file);
                BufferedWriter rd = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
                rd.write(content);
                rd.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static void createbat(String problemname,String domainname,String path){
        try {
            if(path.equals("default"))
                path="./bin/PROBLEM/make.bat";
            File file = new File(path); // 不指定新建文件类型，即可生成“文件”类型给JSHOP2调用。
            OutputStream out = new FileOutputStream(file);
            BufferedWriter rd = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
            rd.write(
                    "java JSHOP2.InternalDomain "+domainname+"\n" +
                    "java JSHOP2.InternalDomain -r "+problemname+"\n" +
                    "javac problem.java\n" +
                    "java problem\n"+" del *.java\n" +
                            "  del *.txt\n" +
                            "  del *.class");
            rd.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*
*
*   cd examples\basic
  java JSHOP2.InternalDomain basic
  java JSHOP2.InternalDomain -r problem
  javac problem.java
  java problem
  del basic.java
  del basic.txt
  del problem.java
  del *.class
  cd ..\..
  goto :End
*
*
* */

    // 输入 cmdpath：bat文件的路径 cmd：bat文件名称
// 输出 JSHOP2的规划结果，若失败则返回null。
// e.g. String outputString = runCmd("D:\\JSHOP2\\Workspace\\transresource", "main");
    public static String runCmd(String cmdpath, String cmd) {
        String result = "";
        File dir = new File(cmdpath);
        try {
            Process ps = Runtime.getRuntime().exec("cmd /c " + cmd, null, dir);
            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream(), Charset.forName("GBK")));
            String line = null;
            while ((line = br.readLine()) != null) {
                // System.out.println(line);
                result += line + "\n";
            }
            br.close();
            ps.waitFor();
            System.out.println(result);
            return result;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("error");
        return null;

    }


}
