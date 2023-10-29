package study2.Plugin;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Factory.ToolServiceFactory;
import study2.Plugin.PluginClassLoader;
import study2.utils.VariableUtil;

public class PluginManager {
    static{
        System.out.println(PluginManager.class.getName());
    }
    private Map<String ,PluginClassLoader> pluginMap = new HashMap<String,PluginClassLoader>();
    private static String packagename = "p1.service."+VariableUtil.CurrentPuluinName.split("\\.")[0];
    public PluginManager(){

    }

    public void service(String pluginName,ArrayList valueList){

        try{
        	packagename = "p1.service."+VariableUtil.CurrentPuluinName.split("\\.")[0];
        	System.out.println(pluginName);
        	System.out.println(packagename);
            Class<?> forName = Class.forName(packagename, true, getLoader(pluginName));//this.pluginMap.get(pluginName).loadClass(packagename);
            ToolServiceFactory ins = (ToolServiceFactory)forName.newInstance();
            System.out.println(ins.service(valueList));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public boolean test(String pluginName){
  
        try{
        	packagename = "p1.service."+VariableUtil.CurrentPuluinName.split("\\.")[0];
            Class<?> forName = Class.forName(packagename, true, getLoader(pluginName));//this.pluginMap.get(pluginName).loadClass(packagename);
            ToolServiceFactory ins = (ToolServiceFactory)forName.newInstance();
            String string=ins.V();
            System.out.println(string);
            if (string.equals("SUCCESS")) {
            	return true;
            }else 
            	return false;
            
        }catch(Exception e){
            e.printStackTrace();
    		return false;
        }
    }
    public void view(String pluginName){

        try{
        	packagename = "p1.service."+VariableUtil.CurrentPuluinName.split("\\.")[0];
            Class<?> forName = Class.forName(packagename, true, getLoader(pluginName));//this.pluginMap.get(pluginName).loadClass(packagename);
            ToolServiceFactory ins = (ToolServiceFactory)forName.newInstance();
            String string=ins.getjSONString();
            System.out.println(string);
            VariableUtil.jsonstring=string;
            VariableUtil.b.setString(string);
        }catch(Exception e){
            e.printStackTrace();
    		//return false;
        }
		//return false;
    }
    private void addLoader(String pluginName,PluginClassLoader loader){
        this.pluginMap.put(pluginName, loader);
    }
    private PluginClassLoader getLoader(String pluginName){
        return this.pluginMap.get(pluginName);
    }
    public void loadPlugin(String pluginName){//加载插件
    	packagename = "p1.service."+VariableUtil.CurrentPuluinName.split("\\.")[0];
        this.pluginMap.remove(pluginName);
        PluginClassLoader loader = new PluginClassLoader();
        String pluginurl = "jar:file:/"+VariableUtil.CurrentPuluinPath+"!/";
        pluginurl=pluginurl.replace("\\","/");
        System.out.println(pluginurl);
        URL url = null;
        try {
            url = new URL(pluginurl);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        loader.addURLFile(url);
        System.out.println(pluginName.split("\\."));
        addLoader(pluginName.split("\\.")[0], loader);
        System.out.println("load " + pluginName + "  success");
    }
    public void unloadPlugin(String pluginName){
        this.pluginMap.get(pluginName.split("\\.")[0]).unloadJarFiles();
        this.pluginMap.remove(pluginName.split("\\.")[0]);
    }
}