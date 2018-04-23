package egovframework.example.mger.service;

import java.util.HashMap;
import java.util.List;

public interface MgerService {
	
	//VO 안만들고 그냥 맵으로 만듦
	/**
	 * 회원 목록 조회
	 * @return
	 * @throws Exception
	 */
	public List<HashMap<String, Object>> selectMgerList(HashMap<String, Object> params) throws Exception;
	
	/**
	 * 상세보기
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public HashMap<String, Object> selectMgerItem(HashMap<String, Object> params) throws Exception;
	
	/**
	 * 회원가입
	 * @param params
	 * @throws Exception
	 */
	public void insertMgerItem(HashMap<String, Object> params) throws Exception;
	
	/**
	 * 회원수정
	 * @param params
	 * @throws Exception
	 */
	public void updateMgerItem(HashMap<String, Object> params) throws Exception;
	
	/**
	 * 회원삭제
	 * @param params
	 * @throws Exception
	 */
	public void deleteMgerItem(HashMap<String, Object> params) throws Exception;
		
	
	
}
