package org.fog.examples;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

import org.fog.entities.FogDevice;
import org.fog.entities.Sensor;

public class Read {
     static List<FogDevice> fogDevices = new ArrayList<FogDevice>();
     static List<String> Mylist = new ArrayList<String>();
     static List<Sensor> sensors = new ArrayList<Sensor>();
    static List<String> fogNode = new ArrayList<>();
    static List<String> linkNode = new ArrayList<>();
    static List<String> moduleNode = new ArrayList<>();
    static List<String> fd= new ArrayList<>();
    static String str ;

    public static void main(String[] args) {
        File file = new File("/home/madhu/Desktop/data.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String data[] = reader.readLine().split(",");
            String s;
            int nbline=0, i=0,block =0;
            while ((s = reader.readLine())!=null && block < data.length) {
                if(s.equals("")){ 
                    block++;
                    nbline = Integer.parseInt(data[block-1]);
                    i = 0;
                }
                for(;i<nbline;i++){
                    s = reader.readLine();
                    if(s == null) break;
                    else if(s.equals("")){
                        block++;
                        break;
                    }
                    switch(block){
                        case 1 :
                            fogNode.add(s);
                            break;
                        case 2:
                           linkNode.add(s);
                            break;
                        default: moduleNode.add(s);
                    }
                }
            }

        } catch (IOException | NumberFormatException ex) {
            System.err.println(ex.getStackTrace());
        } 
        finally{
            closeReader(reader);
        }
       //String st = fogNode.toString();   
       // String[] stt =  st.split(" ");
     
       /*for(String s: stt) {
    	fd.add(s);
       System.out.println(s);
       } */
        System.out.println("nodes: "+fogNode);
        System.out.println("Links : "+linkNode);
       // System.out.println("modules : "+moduleNode);
        Iterator<String> nodeString = fogNode.iterator();
        Iterator<String> nodeString1 = fogNode.iterator();
        while (nodeString.hasNext()) {
        	 str = nodeString.next();
        	 FogDevice fd = createFogDevice(str);
        	 //fogDevices.add(fd);
        	System.out.println(str);
        }
        
        
        
        System.out.println(str);
        System.out.println("Fog :"+fd);
    }

    private static FogDevice createFogDevice(String str2) {
		String[] parameters = str2.split(",") ;
		String name = parameters[0];
		int level = Integer.parseInt(parameters[1]);
		double Uplink_BW = Double.parseDouble(parameters[2]);
		double Downlink_BW = Double.parseDouble(parameters[3]);
		int Ram = Integer.parseInt(parameters[4]);
		Long Mips = Long.parseLong(parameters[5]);
		double ratepermips = Double.parseDouble(parameters[6]);
		if (level == 0) {
			setParentId(-1); 
		}else {
			 setParentId(parent.getId()); 
			
		}
		
		return null;
	}

	public static void closeReader(BufferedReader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
            }
        }
    }
   

}
