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

package ustc.mike.overwatch.server.web;

import com.alibaba.fastjson.JSON;
import ustc.mike.overwatch.common.data.Client;
import ustc.mike.overwatch.server.data.Common;
import ustc.mike.overwatch.server.data.RecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;

/**
 * @author Mike
 * @project overwatch
 * @date 10/12/2017, 3:06 PM
 * @e-mail mike@mikecoder.cn
 */
@Controller
@EnableAutoConfiguration
public class ClientController {
    
    @Autowired
    RecordRepository recordRepository;
    
    @RequestMapping(value = "/clients")
    @ResponseBody
    public String getClientList() {
        return JSON.toJSONString(Common.clients.getClients().values());
    }
    
    @RequestMapping(value = "/client", method = RequestMethod.GET)
    @ResponseBody
    public String getClientRecords(@RequestParam(name = "name") String name,
                                   @RequestParam(name = "start") long start,
                                   @RequestParam(name = "end") long end)
    {
        return JSON.toJSONString(recordRepository.getRecords(name, start, end));
    }
    
//    @RequestMapping(value = "/client", method = RequestMethod.DELETE)
    @RequestMapping(value = "/delclient", method = RequestMethod.GET)
    @ResponseBody
    public String deleteClient(@RequestParam(name = "name") String name) {
        Common.clients.getClients().remove(name);
        return "{}";
    }
    
    @RequestMapping(value = "/alert", method = RequestMethod.GET)
    @ResponseBody
    public String alert() {
        LinkedList<Client> clients = new LinkedList<Client>();
        for (Client client : Common.clients.getClients().values()) {
            if (!client.isOnline()) {
                clients.add(client);
            }
        }
        return JSON.toJSONString(clients);
    }
}
