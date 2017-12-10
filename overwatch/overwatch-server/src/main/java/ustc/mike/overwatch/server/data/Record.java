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

package ustc.mike.overwatch.server.data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Mike
 * @project overwatch
 * @date 10/12/2017, 3:55 PM
 * @e-mail mike@mikecoder.cn
 */
@Entity
public class Record {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private Double avgload;
    
    @Column(nullable = false)
    private String os;
    
    @Column(nullable = false)
    private Long timestamp;
    
    @Column(nullable = false)
    private Integer cpunum;
    
    
    public Record() { }
    
    public Record(String name, Double avgload, String os, Long timestamp, Integer cpunum) {
        this.name = name;
        this.avgload = avgload;
        this.os = os;
        this.timestamp = timestamp;
        this.cpunum = cpunum;
    }
    
    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(Long id) {
        this.id = id;
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
    
    /**
     * Getter for property 'avgload'.
     *
     * @return Value for property 'avgload'.
     */
    public Double getAvgload() {
        return avgload;
    }
    
    /**
     * Setter for property 'avgload'.
     *
     * @param avgload Value to set for property 'avgload'.
     */
    public void setAvgload(Double avgload) {
        this.avgload = avgload;
    }
    
    /**
     * Getter for property 'os'.
     *
     * @return Value for property 'os'.
     */
    public String getOs() {
        return os;
    }
    
    /**
     * Setter for property 'os'.
     *
     * @param os Value to set for property 'os'.
     */
    public void setOs(String os) {
        this.os = os;
    }
    
    /**
     * Getter for property 'timestamp'.
     *
     * @return Value for property 'timestamp'.
     */
    public Long getTimestamp() {
        return timestamp;
    }
    
    /**
     * Setter for property 'timestamp'.
     *
     * @param timestamp Value to set for property 'timestamp'.
     */
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
    
    /**
     * Getter for property 'cpunum'.
     *
     * @return Value for property 'cpunum'.
     */
    public Integer getCpunum() {
        return cpunum;
    }
    
    /**
     * Setter for property 'cpunum'.
     *
     * @param cpunum Value to set for property 'cpunum'.
     */
    public void setCpunum(Integer cpunum) {
        this.cpunum = cpunum;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Record record = (Record) o;
        
        if (id != null ? !id.equals(record.id) : record.id != null) return false;
        if (name != null ? !name.equals(record.name) : record.name != null) return false;
        if (avgload != null ? !avgload.equals(record.avgload) : record.avgload != null) return false;
        if (os != null ? !os.equals(record.os) : record.os != null) return false;
        if (timestamp != null ? !timestamp.equals(record.timestamp) : record.timestamp != null) return false;
        return cpunum != null ? cpunum.equals(record.cpunum) : record.cpunum == null;
    }
    
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (avgload != null ? avgload.hashCode() : 0);
        result = 31 * result + (os != null ? os.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (cpunum != null ? cpunum.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avgload=" + avgload +
                ", os='" + os + '\'' +
                ", timestamp=" + timestamp +
                ", cpunum=" + cpunum +
                '}';
    }
}
