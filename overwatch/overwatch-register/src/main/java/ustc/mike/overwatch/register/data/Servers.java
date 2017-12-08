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

package ustc.mike.overwatch.register.data;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Mike
 * @project overwatch
 * @date 08/12/2017, 11:39 AM
 * @e-mail mike@mikecoder.cn
 */
public class Servers extends Data {
    private volatile ConcurrentHashMap<String, Server> servers = new ConcurrentHashMap<String, Server>();
    
    /**
     * Getter for property 'servers'.
     *
     * @return Value for property 'servers'.
     */
    public ConcurrentHashMap<String, Server> getServers() {
        return servers;
    }
    
    /**
     * Setter for property 'servers'.
     *
     * @param servers Value to set for property 'servers'.
     */
    public void setServers(
            ConcurrentHashMap<String, Server> servers)
    {
        this.servers = servers;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Servers servers1 = (Servers) o;
        
        return servers != null ? servers.equals(servers1.servers) : servers1.servers == null;
    }
    
    @Override
    public int hashCode() {
        return servers != null ? servers.hashCode() : 0;
    }
}
