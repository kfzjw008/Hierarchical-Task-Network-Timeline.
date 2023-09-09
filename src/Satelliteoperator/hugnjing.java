package Satelliteoperator;

import Satelliteoperator.tableclass.TaskInformation;

import java.util.ArrayList;

/**
 * @program: JSHOP2
 * @description: 测试环境
 * @author: kfzjw008(Junwei Zhang)
 * @create: 2023-09-09 15:39
 **/
public class hugnjing {
    //1号环境
    public static ArrayList<TaskInformation>  huanjing1T1(){
        ArrayList<TaskInformation> taskInformationTable = new ArrayList<>();
        taskInformationTable.add(new TaskInformation( "!navigate", "E001", "01", 30, 10));
        taskInformationTable.add(new TaskInformation( "!sample_soil", "E002", "02", 15, 5));
        taskInformationTable.add(new TaskInformation( "!sample_rock", "E003", "02", 15, 20));
        taskInformationTable.add(new TaskInformation( "!drop", "E004", "03", 20, 10));
        taskInformationTable.add(new TaskInformation( "!calibrate", "E005", "04", 1, 100));
        taskInformationTable.add(new TaskInformation( "!take_image", "E006", "05", 5, 8));
        taskInformationTable.add(new TaskInformation( "!communicate_soil_data", "E007", "06", 30, 12));
        taskInformationTable.add(new TaskInformation( "!communicate_rock_data", "E008", "06", 20, 3));
        taskInformationTable.add(new TaskInformation( "!communicate_image_data", "E009", "06", 40, 1));
        taskInformationTable.add(new TaskInformation( "!visit", "E00A", "07", 5, 25));
        taskInformationTable.add(new TaskInformation( "!unvisit", "E00B", "07", 5, 30));
        return  taskInformationTable;
    }
}
