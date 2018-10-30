package pack.business;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SqlMapperInter {
	@Select("select * from membertab") // 밑에까지 한 묶음.
	public List<DataDto> selectDataAll();
	
	@Select("select * from membertab where id=#{id}")
	public DataDto selectDatapart(String id);
	
	@Insert("insert into membertab values(#{id},#{name},#{passwd},now())")
	public int insertData(DataFormBean bean);
	
	@Update("update membertab set name=#{name} where id=#{id}")
	public int updateData(DataFormBean bean);
	
	@Delete("delete from membertab where id=#{id}")
	public int deleteData(String id);
}