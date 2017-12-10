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

package ustc.mike.overwatch.register;

import ustc.mike.overwatch.register.net.NettyServer;
import ustc.mike.overwatch.register.web.CheckClientController;
import ustc.mike.overwatch.register.web.CheckServerController;

import org.springframework.boot.SpringApplication;

/**
 * @author Mike
 * @project overwatch
 * @date 08/12/2017, 11:10 AM
 * @e-mail mike@mikecoder.cn
 */

public class Main {
    public static void main(String[] args) throws Exception {
        Object[] classes = new Object[3];
        classes[0] = CheckClientController.class;
        classes[1] = CheckServerController.class;
        classes[2] = NettyServer.class;
        
        SpringApplication.run(classes, args);
    }
}
