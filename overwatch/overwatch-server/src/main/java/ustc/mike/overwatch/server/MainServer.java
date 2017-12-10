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

package ustc.mike.overwatch.server;

import ustc.mike.overwatch.common.data.Command;
import ustc.mike.overwatch.common.data.CommandType;
import ustc.mike.overwatch.common.data.Server;
import ustc.mike.overwatch.server.net.NettyServer;
import ustc.mike.overwatch.server.web.ClientController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;

/**
 * @author Mike
 * @project overwatch
 * @date 10/12/2017, 3:05 PM
 * @e-mail mike@mikecoder.cn
 */
@SpringBootApplication
@Component
@EnableAutoConfiguration
public class MainServer {
    
    @Value("${overwatch.register.port:9090}")
    int    port;
    @Value("${overwatch.register.ip:127.0.0.1}")
    String ip;
    
    private Server server = new Server();
    
    @PostConstruct
    public void start() throws InterruptedException, IOException {
        server.setIp(InetAddress.getLocalHost().getHostAddress());
        System.out.println(ip + port);
        Socket socket = new Socket(ip, port);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Command command = new Command();
        command.setType(CommandType.SERVER_ONLINE);
        HashMap<String, String> contents = new HashMap<String, String>();
        contents.put("ip", server.getIp());
        command.setContents(contents);
        
        writer.write(command.toString());
        writer.flush();
    }
    
    public static void main(String[] args) {
        Object[] classes = new Object[3];
        classes[0] = MainServer.class;
        classes[1] = ClientController.class;
        classes[2] = NettyServer.class;
    
        SpringApplication.run(classes, args);
    }
}
