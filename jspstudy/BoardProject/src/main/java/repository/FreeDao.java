package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Free;

public class FreeDao {
	
	private SqlSessionFactory factory;
	
	private static FreeDao dao = new FreeDao();
	private FreeDao() {
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static FreeDao getInstance() {
		return dao;
	}
	
	String mapper = "mybatis.mapper.free.";
	
	public List<Free> selectAllFrees(){
		SqlSession ss = factory.openSession();
		List<Free> boards = ss.selectList(mapper + "selectAllFrees");
		ss.close();
		return boards;
	}
	
	public int insertFree(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert(mapper + "insertFree");
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;		
	}

}
