/*******************************************************************************
 * Copyright © 2016 TangDongxin
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 ******************************************************************************/

package ustc.mike.overwatch.common.data;

/**
 * @author Mike
 * @project overwatch
 * @date 10/12/2017, 3:31 PM
 * @e-mail mike@mikecoder.cn
 */
public class Report extends Data {
    private String name;
    private String OS;
    private double load;
    private int    cpus;
    
    /**
     * Getter for property 'OS'.
     *
     * @return Value for property 'OS'.
     */
    public String getOS() {
        return OS;
    }
    
    /**
     * Setter for property 'OS'.
     *
     * @param OS Value to set for property 'OS'.
     */
    public void setOS(String OS) {
        this.OS = OS;
    }
    
    /**
     * Getter for property 'load'.
     *
     * @return Value for property 'load'.
     */
    public double getLoad() {
        return load;
    }
    
    /**
     * Setter for property 'load'.
     *
     * @param load Value to set for property 'load'.
     */
    public void setLoad(double load) {
        this.load = load;
    }
    
    /**
     * Getter for property 'cpus'.
     *
     * @return Value for property 'cpus'.
     */
    public int getCpus() {
        return cpus;
    }
    
    /**
     * Setter for property 'cpus'.
     *
     * @param cpus Value to set for property 'cpus'.
     */
    public void setCpus(int cpus) {
        this.cpus = cpus;
    }
    
    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Report report = (Report) o;
        
        if (Double.compare(report.load, load) != 0) return false;
        if (cpus != report.cpus) return false;
        if (name != null ? !name.equals(report.name) : report.name != null) return false;
        return OS != null ? OS.equals(report.OS) : report.OS == null;
    }
    
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (OS != null ? OS.hashCode() : 0);
        temp = Double.doubleToLongBits(load);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + cpus;
        return result;
    }
}
