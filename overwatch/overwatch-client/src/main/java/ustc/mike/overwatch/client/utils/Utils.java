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

package ustc.mike.overwatch.client.utils;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.Random;

/**
 * @author Mike
 * @project overwatch
 * @date 10/12/2017, 3:08 PM
 * @e-mail mike@mikecoder.cn
 */
public class Utils {
    
    public static String genRandomName() {
        int maxNum = 255;
        int i;
        int count = 0;
        char[] str = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuilder pwd = new StringBuilder("");
        Random r = new Random();
        while (count < 8) {
            i = Math.abs(r.nextInt(maxNum));
            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count++;
            }
        }
        return pwd.toString();
    }
    
    public static int getCpuNum() {
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean();
        return osmxb.getAvailableProcessors();
    }
    
    
    public static String getOs() {
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean();
        return osmxb.getArch() + osmxb.getName() + osmxb.getVersion();
    }
    
    public static double getAvgLoad() {
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean();
        return osmxb.getSystemLoadAverage();
    }
}
