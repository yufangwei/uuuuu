package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFac {
	public static Session getSession() {
		//加载src下面的核心配置文件
		Configuration cfg = new Configuration().configure();
		//获取sessionFactory
		SessionFactory sf = cfg.buildSessionFactory();
		//打开工厂（创建一次会话）
		Session s = sf.openSession();
		return s;
	}
	
}
