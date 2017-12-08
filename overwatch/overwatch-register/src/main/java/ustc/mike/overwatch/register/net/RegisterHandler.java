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

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.*;


/**
 * @author Mike
 * @project overwatch
 * @date 08/12/2017, 2:07 PM
 * @e-mail mike@mikecoder.cn
 */
public class RegisterHandler extends SimpleChannelHandler {
    
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
        System.out.println("in messagereceived");
        ChannelBuffer buf = (ChannelBuffer) e.getMessage();
        while (buf.readable()) {
            System.out.print((char) buf.readByte());
            System.out.flush();
        }
    }
    
    @Override
    public void writeRequested(ChannelHandlerContext ctx, MessageEvent e) {
        System.out.println("message event " + e.toString());
    }
    
    @Override
    public void handleUpstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        System.out.println("in upstream");
        if (e instanceof ChannelStateEvent) {
            System.out.println("Channel state changed: " + e);
        }
        super.handleUpstream(ctx, e);
    }
    
    @Override
    public void handleDownstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        System.out.println("in downstream");
        MessageEvent me = null;
        if (e instanceof MessageEvent) {
            System.out.println("Writing:: " + e);
            me = (MessageEvent) e;
        }
        
        
        Channels.write(ctx, me.getFuture(), "write from downstream handler");
        super.handleDownstream(ctx, e);
    }
    
    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("channelconected");
    }
}
