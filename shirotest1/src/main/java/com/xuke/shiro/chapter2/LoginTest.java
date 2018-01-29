package com.xuke.shiro.chapter2;

import org.apache.log4j.net.SyslogAppender;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import junit.framework.Assert;

public class LoginTest {
    
	public void testHelloWorld(){
    	Factory<org.apache.shiro.mgt.SecurityManager> factory=
    			new IniSecurityManagerFactory("classpath:shiro-realm.ini");
    	SecurityManager securityManager = factory.getInstance();
    	SecurityUtils.setSecurityManager(securityManager);
    	Subject subject = SecurityUtils.getSubject();
    	UsernamePasswordToken token=new UsernamePasswordToken("zhang", "123");
    	subject.login(token);
    	try {
    		subject.login(token);
    		System.out.println("successful");
		} catch (AuthenticationException e) {
			System.out.println("error");
		}
    	 Assert.assertEquals(true, subject.isAuthenticated());
    	 subject.logout();;
    }
     
    public void testJdbcRealms(){
   	  
    	 Factory<org.apache.shiro.mgt.SecurityManager> factory =
    		
                 new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
    	 SecurityManager securityManager = factory.getInstance();
    	 SecurityUtils.setSecurityManager(securityManager);
    	 Subject subject = SecurityUtils.getSubject();
    	 UsernamePasswordToken token=new UsernamePasswordToken("zhang","123");
    	 subject.login(token);
    	 
    	 Assert.assertEquals(true, subject.isAuthenticated());
    	 subject.logout();
     }
    
    @Test
    public void testRealms(){
   	  
    	 Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-authenticator-all-success2.ini");
    	 SecurityManager securityManager = factory.getInstance();
    	 SecurityUtils.setSecurityManager(securityManager);
    	 Subject subject = SecurityUtils.getSubject();
    	 UsernamePasswordToken token=new UsernamePasswordToken("zhang","123");
    	 subject.login(token);
    	 
    	 Assert.assertEquals(true, subject.isAuthenticated());
    	 subject.logout();
     }
    
}
