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

package ustc.mike.overwatch.server.net;

import com.alibaba.fastjson.JSON;
import ustc.mike.overwatch.common.data.Client;
import ustc.mike.overwatch.common.data.Command;
import ustc.mike.overwatch.common.data.CommandType;
import ustc.mike.overwatch.common.data.Report;
import ustc.mike.overwatch.server.data.Common;
import ustc.mike.overwatch.server.data.Record;

import org.jboss.netty.channel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Mike
 * @project overwatch
 * @date 08/12/2017, 2:07 PM
 * @e-mail mike@mikecoder.cn
 */
public class ReportHandler extends SimpleChannelHandler {
    
    private Logger logger = LoggerFactory.getLogger(ReportHandler.class.getName());
    
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
        Command command = JSON.parseObject(e.getMessage().toString(), Command.class);
        System.out.println(command);
        switch (command.getType()) {
            case CommandType.CLIENT_ONLINE: {
                Client client = JSON.parseObject(command.getContents().get("client"), Client.class);
                ctx.setAttachment(client);
                logger.info(client.getName() + " online!");
                Common.clients.getClients().put(client.getName(), client);
                break;
            }
            case CommandType.CLIENT_REPORT: {
                Client client = (Client) ctx.getAttachment();
                if (client == null) {
                    // fuck yourself
                    e.getChannel().close();
                }
                
                Report report = JSON.parseObject(command.getContents().get("report"), Report.class);
                
                Record record = new Record();
                record.setAvgload(report.getLoad());
                record.setCpunum(report.getCpus());
                record.setName(report.getName());
                record.setTimestamp(System.currentTimeMillis());
                record.setOs(report.getOS());
                
                Common.recordRepository.save(record);
                System.out.println(JSON.toJSON(Common.recordRepository.findAll()));
                break;
            }
        }
    }
    
    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        Client client = (Client) ctx.getAttachment();
        if (client != null) {
            logger.info(client.getName() + " offline!");
            Common.clients.getClients().get(client.getName()).setOnline(false);
        }
        super.channelClosed(ctx, e);
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
