/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assemblyline;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sayyed Shozib Abbas
 */
public class AssemblyLine {
    
    public static int numberofPCs;
    public static int totalExecutionTime;

    AssemblyLine() {
        this.totalExecutionTime = 0;
    }
    
    public static int getShortestTime(List<station> line1, List<station> line2, List<station> line3) {
        return getShortestTime(line1, line2, line3, line1.size() - 1);
    }
    
    public static int getShortestTime(List<station> line1, List<station> line2, List<station> line3, int currentStation) {
                
        if(currentStation == 0)
            return 1;
        else {
            int line1Min = line1.get(currentStation).executionTime + line1.get(currentStation).transitionTime;
            int line2Min = line2.get(currentStation).executionTime + line2.get(currentStation).transitionTime;
            int line3Min = line3.get(currentStation).executionTime + line3.get(currentStation).transitionTime;
            
             
            return Math.min(line1Min, Math.min(line2Min, line3Min)) + getShortestTime(line1, line2, line3, currentStation - 1);
            
        }
                
    }
    
    public static station getBestStation(station s1, station s2) {
        if(s1.transitionTime < s2.transitionTime && s1.isEnabled == true)
            return s1;
        else
            return s2;
    }
    
    public static void main(String[] args) {
        ArrayList<station> line1, line2, line3;
        
        line1 = new ArrayList<station>();
        line2 = new ArrayList<station>();
        line3 = new ArrayList<station>();
        
        line1.add(new station("L1S1", 1, 1));
        line1.add(new station("L1S2", 2, 45));
        line1.add(new station("L1S3", 3, 65));
        line1.add(new station("L1S4", 4, 12));
        
        line2.add(new station("L2S1", 1, 54));
        line2.add(new station("L2S2", 2, 87));
        line2.add(new station("L2S3", 3, 36));
        line2.add(new station("L2S4", 4, 65));
        
        line3.add(new station("L3S1", 1, 34));
        line3.add(new station("L3S2", 2, 87));
        line3.add(new station("L3S3", 3, 67));
        line3.add(new station("L2S4", 4, 12));
        
        System.out.println("Time for 1 PC: " + AssemblyLine.getShortestTime(line1, line2, line3));
        
    }
    
}
