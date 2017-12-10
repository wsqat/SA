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

package ustc.mike.overwatch.register.net;

import com.alibaba.fastjson.JSON;
import ustc.mike.overwatch.common.data.Command;
import ustc.mike.overwatch.common.data.CommandType;
import ustc.mike.overwatch.register.data.Common;
import ustc.mike.overwatch.common.data.Server;

import org.jboss.netty.channel.*;


/**
 * @author Mike
 * @project overwatch
 * @date 08/12/2017, 2:07 PM
 * @e-mail mike@mikecoder.cn
 */
public class RegisterHandler extends SimpleChannelHandler {
    
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
        Command command = (Command) JSON.parseObject(e.getMessage().toString(), Command.class);
        System.out.println(command);
        switch (command.getType()) {
            case CommandType.SERVER_ONLINE: {
                Server server = new Server();
                server.setId(Common.SERVER_ID.getAndAdd(1));
                server.setIp(command.getContents().get("ip"));
            
                Common.SERVERS.getServers().put(String.valueOf(server.getId()), server);
            
                e.getChannel().write(server.toString());
                break;
            }
            case CommandType.CLIENT_REGIST: {
                boolean hasServer = false;
                for (Server server : Common.SERVERS.getServers().values()) {
                    e.getChannel().write(server.toString());
                    hasServer = true;
                    break;
                }
            
                if (!hasServer) e.getChannel().write("No Server");
                break;
            }
        }
    }
    
    @Override
    public void writeRequested(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        super.writeRequested(ctx, e);
    }
    
    @Override
    public void handleUpstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        super.handleUpstream(ctx, e);
    }
    
    @Override
    public void handleDownstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        super.handleDownstream(ctx, e);
    }
    
    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        super.channelConnected(ctx, e);
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        System.out.println(e.toString());
        e.getCause().printStackTrace();
    }
    
}
