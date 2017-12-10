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

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * @author Mike
 * @project overwatch
 * @date 10/12/2017, 1:41 PM
 * @e-mail mike@mikecoder.cn
 */
public class Command {
    
    private int type;
    
    private HashMap<String, String> contents;
    
    /**
     * Getter for property 'type'.
     *
     * @return Value for property 'type'.
     */
    public int getType() {
        return type;
    }
    
    /**
     * Setter for property 'type'.
     *
     * @param type Value to set for property 'type'.
     */
    public void setType(int type) {
        this.type = type;
    }
    
    /**
     * Getter for property 'contents'.
     *
     * @return Value for property 'contents'.
     */
    public HashMap<String, String> getContents() {
        return contents;
    }
    
    /**
     * Setter for property 'contents'.
     *
     * @param contents Value to set for property 'contents'.
     */
    public void setContents(HashMap<String, String> contents) {
        this.contents = contents;
    }
    
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Command command = (Command) o;
        
        if (type != command.type) return false;
        return contents != null ? contents.equals(command.contents) : command.contents == null;
    }
    
    @Override
    public int hashCode() {
        int result = type;
        result = 31 * result + (contents != null ? contents.hashCode() : 0);
        return result;
    }
}
