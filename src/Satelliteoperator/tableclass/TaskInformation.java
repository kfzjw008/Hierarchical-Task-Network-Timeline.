package Satelliteoperator.tableclass;

/**
 * @program: JSHOP2
 * @description: 任务信息配置表单行的仿真
 * @author: kfzjw008(Junwei Zhang)
 * @create: 2023-09-09 13:39
 **/
public class TaskInformation {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskInformation(String name, String id, String zh, int time, int yxj,int R1) {
        this.name = name;
        this.id = id;
        this.zh = zh;
        this.time = time;
        this.yxj = yxj;
        this.R1=R1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZh() {
        return zh;
    }

    public void setZh(String zh) {
        this.zh = zh;
    }

    public int  getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getYxj() {
        return yxj;
    }

    public void setYxj(int yxj) {
        this.yxj = yxj;
    }

    private String id;

    public int getR1() {
        return R1;
    }

    public void setR1(int r1) {
        R1 = r1;
    }

    private String zh;
    private int time;
    private int yxj;
    private int R1;
}
