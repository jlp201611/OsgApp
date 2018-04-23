package egovframework.example.mger.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.mger.service.MgerService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("MgerService") //MgerServiceImpl의 변수명을 MgerService로 
public class MgerServiceImpl extends EgovAbstractServiceImpl implements MgerService {

	@Autowired
	private MgerMapper mgre;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public List<HashMap<String, Object>> selectMgerList(HashMap<String, Object> params) throws Exception {
		// TODO 회원 목록 조회
		List<HashMap<String, Object>> result = mgre.selectMgerList(params);
		
		
		return result;
	}

	@Override
	public void insertMgerItem(HashMap<String, Object> params) throws Exception {
		// TODO 회원등록
		mgre.insertMgerItem(params);
		
	}

	@Override
	public void updateMgerItem(HashMap<String, Object> params) throws Exception {
		// TODO 회원수정
		mgre.updateMgerItem(params);
		
	}

	@Override
	public void deleteMgerItem(HashMap<String, Object> params) throws Exception {
		// TODO 회원삭제
		mgre.deleteMgerItem(params);
		
	}

	@Override
	public HashMap<String, Object> selectMgerItem(HashMap<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		log.debug("selectMgerItem => {}",params);
		return mgre.selectMgerItem(params);
	}





}
