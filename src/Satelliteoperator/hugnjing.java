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
        taskInformationTable.add(new TaskInformation( "!navigate", "e001", "01", 30, 10,10));
        taskInformationTable.add(new TaskInformation( "!sample_soil", "e002", "02", 15, 5,20));
        taskInformationTable.add(new TaskInformation( "!sample_rock", "e003", "02", 15, 20,30));
        taskInformationTable.add(new TaskInformation( "!drop", "e004", "03", 20, 10,40));
        taskInformationTable.add(new TaskInformation( "!calibrate", "005", "04", 1, 100,30));
        taskInformationTable.add(new TaskInformation( "!take_image", "e006", "05", 5, 8,60));
        taskInformationTable.add(new TaskInformation( "!communicate_soil_data", "e007", "06", 30, 12,10));
        taskInformationTable.add(new TaskInformation( "!communicate_rock_data", "e008", "06", 20, 3,10));
        taskInformationTable.add(new TaskInformation( "!communicate_image_data", "e009", "06", 40, 1,10));
        taskInformationTable.add(new TaskInformation( "!visit", "e00A", "07", 5, 25,30));
        taskInformationTable.add(new TaskInformation( "!unvisit", "e00B", "07", 5, 30,10));
        return  taskInformationTable;
    }
}
