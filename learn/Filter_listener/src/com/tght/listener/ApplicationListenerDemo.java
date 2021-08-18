package com.tght.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ApplicationListenerDemo implements ServletContextListener {


    public void contextDestroyed(ServletContextEvent sce)  { 
        System.out.println("aplication创建啦！");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("aplication销毁啦！");
    }
	
}
