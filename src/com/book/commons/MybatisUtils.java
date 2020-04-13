package com.book.commons;
/**
 * �����ȡ�����ļ�������ִ�ж��󣬹ر�ִ�ж���
 * @author Lenovo
 *
 */

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	private static SqlSessionFactory fac;
	static {
		try {
			fac=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("MyBatis-config.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//����һ������sqlsession����ķ���
	public static SqlSession createSqlSession() {
		return fac.openSession(false);
	}
	//����һ���ر�sqlsession����ķ���
	public static void closeSqlSession(SqlSession sqlSession) {
		if(sqlSession!=null) {
			sqlSession.close();
		}
	}
}
