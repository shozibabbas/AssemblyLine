/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assemblyline;

/**
 *
 * @author Sayyed Shozib Abbas
 */
class station {
    public String stationName;
    public int executionTime;
    public int transitionTime;
    public boolean isEnabled;
    
    public station(String stationName, int executionTime, int lineTransitionTime) {
        this.stationName = stationName;
        this.executionTime = executionTime;
        this.transitionTime = lineTransitionTime;
        this.isEnabled = true;
    }
}
