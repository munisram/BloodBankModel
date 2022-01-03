package com.chainsys.sample;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    BeanFactory bean=new XmlBeanFactory(new FileSystemResource("Spring.xml"));	
    	
    Actor a=(Actor) bean.getBean("agies");	
   	a.name("munis");
    	
    	
    	
      
    }
}
