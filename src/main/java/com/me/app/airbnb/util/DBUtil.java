package com.me.app.airbnb.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.me.app.airbnb.model.Room;


public class DBUtil {
	
	public static void main(String[] args) {
		//testUpdate();
		System.out.println(findCountByRoomId(1122343L));
		System.out.println(Util.findStr("https://zh.airbnb.com/rooms/10184115?location=%E4%B8%8A%E6%B5%B7%2C%20%E4%B8%AD%E5%9B%BD&s=hkD9bNHJ", "\\d+"));
	}
	
	public static void add(Room r){
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();
			session.insert("com.me.app.airbnb.model.Room.add",r);
			session.commit();
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Integer findCountByRoomId(Long roomId){
		Integer count = 0;
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();
			if(roomId != null){
				count = session.selectOne("com.me.app.airbnb.model.Room.findCountByRoomId",roomId);
			}
			session.commit();
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return count;
	}
}
