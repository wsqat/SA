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
 * @date 08/12/2017, 11:20 AM
 * @e-mail mike@mikecoder.cn
 */
public class Client extends Data {
    private boolean isOnline;
    private String  ip;
    private String  name;
    
    /**
     * Getter for property 'online'.
     *
     * @return Value for property 'online'.
     */
    public boolean isOnline() {
        return isOnline;
    }
    
    /**
     * Setter for property 'online'.
     *
     * @param online Value to set for property 'online'.
     */
    public void setOnline(boolean online) {
        isOnline = online;
    }
    
    /**
     * Getter for property 'ip'.
     *
     * @return Value for property 'ip'.
     */
    public String getIp() {
        return ip;
    }
    
    /**
     * Setter for property 'ip'.
     *
     * @param ip Value to set for property 'ip'.
     */
    public void setIp(String ip) {
        this.ip = ip;
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
        
        Client client = (Client) o;
    
        if (isOnline != client.isOnline) return false;
        if (ip != null ? !ip.equals(client.ip) : client.ip != null) return false;
        return name != null ? name.equals(client.name) : client.name == null;
    }
    
    @Override
    public int hashCode() {
        int result = (isOnline ? 1 : 0);
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
