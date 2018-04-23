package egovframework.example.mger.service.impl;

import java.util.HashMap;
import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("egovframework.example.mger.service.impl.MgerMapper")
public interface MgerMapper {
	
	public List<HashMap<String, Object>> selectMgerList(HashMap<String, Object> params ) throws Exception;
	
	public HashMap<String, Object> selectMgerItem(HashMap<String, Object> params) throws Exception;
	/**
	 * 회원등
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public void insertMgerItem(HashMap<String, Object> params ) throws Exception;
	
	/**
	 * 회원수정
	 * @param params
	 * @throws Exception
	 */
	public void updateMgerItem(HashMap<String, Object> params ) throws Exception;
	
	/**
	 * 회원삭제
	 * @param params
	 * @throws Exception
	 */
	public void deleteMgerItem(HashMap<String, Object> params) throws Exception;
}
