/*
package com.example;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RibbonClients
@RestController
public class DemoApplication {
    @Autowired
    private SpringClientFactory clientFactory;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



    @RequestMapping("/")
    public void getServerList() throws Exception {
        ZoneAwareLoadBalancer<Server> lb = (ZoneAwareLoadBalancer<Server>) clientFactory.getLoadBalancer("myclient");
        ServerList<Server> serverList = lb.getServerListImpl();



        List<Server> serverDetailList = serverList.getInitialListOfServers();
        if (!CollectionUtils.isEmpty(serverDetailList)) {
            for (Server s : serverDetailList) {
                System.out.println(s.getHost() + "," + s.getPort());
            }
        } else {
            System.out.println("no service");
        }


    }
}
*/
