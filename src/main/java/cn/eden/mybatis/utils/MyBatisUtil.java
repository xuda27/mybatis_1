package cn.eden.mybatis.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;

public class MyBatisUtil {
	private static SqlSessionFactory  factory = null;
	
	static {
		// 1、加载mybatis框架的配置文件
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream("conf.xml");
			LogManager.getLogger().debug("加载mybatis框架的配置文件conf.xml成功..");
		} catch (IOException e) {
			LogManager.getLogger().error("加载mybatis框架的配置文件conf.xml失败..");
		}
		// 2、通过配置文件数据流创建sessionFactory对象
		LogManager.getLogger().debug("通过配置文件数据流创建sessionFactory对象..");
		factory = new SqlSessionFactoryBuilder().build(in);
	}
	
	/**
	 * 获取SqlSession对象
	 * @return SqlSession对象
	 */
	public static SqlSession getSession(){
		LogManager.getLogger().debug("获取SqlSession对象..");

		return factory.openSession();
	}
	
	/**
	 * 获取SqlSession对象
	 * @param isCommit 提交事务
	 * @return
	 */
	public static SqlSession getSession(boolean isCommit){
		LogManager.getLogger().debug("获取SqlSession对象 提交事务?..");
		return factory.openSession(isCommit);
	}
	
	/**
	 * 关闭SqlSession对象
	 * @param session
	 */
	public static void close(SqlSession session){
		if(session != null){
			session.close();
			LogManager.getLogger().debug("关闭SqlSession对象?..");
		}
	}
	
}
