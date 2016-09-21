package cn.eden.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.eden.mybatis.mapper.ClassMapper;
import cn.eden.mybatis.pojo.Classes;
import cn.eden.mybatis.utils.MyBatisUtil;

public class Test1 {
	@Test
	public void testSelectClassById(){
		SqlSession session = MyBatisUtil.getSession();
		ClassMapper classMapper = session.getMapper(ClassMapper.class);
		Classes c = classMapper.SelectClassById(1001);
		System.out.println(c);
		session.close();
	}
	
	/**
	 * 绕过接口的抽象方法
	 */
	@Test
	public void testSelectClassById2(){
		SqlSession session = MyBatisUtil.getSession();
		/**
		 * 映射sql的标识字符串
		 * cn.eden.mybatis.mapper.ClassMapper是ClassMapper.xml的mapper标签的namespace属性值
		 * SelectClassById2是select标签的id属性值， 通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "cn.eden.mybatis.mapper.ClassMapper.SelectClassById2";
		Classes c = session.selectOne(statement, 1001);
		System.out.println(c);
		session.close();
	}
	
	
}
