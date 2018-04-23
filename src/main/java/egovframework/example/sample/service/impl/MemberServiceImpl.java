package egovframework.example.sample.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.sample.service.MemberService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("MemberService")
public class MemberServiceImpl extends EgovAbstractServiceImpl implements MemberService {
	/**
	 * 회원정보 검색
	 */
	@Autowired
	private MemberMapper member;
	// private를 쓰는 이유....변수명의 혼용을 막아주고 외부에서 연결 연결 연결해서 접근 하면 어디 인스턴스인지도 잘 몰라서 복잡성이 높아지고해서  접근을  못하게 한다
	// 그냥 일케써...ㅋㅋㅋ 이유는 잘 몰겟어ㅋㅋㅋㅋ
	
	
	@Override
	public HashMap<String, Object> selectMemberItem(HashMap<String, Object> params) throws Exception {
		// TODO 회원정보 (ID, PW 누군지 찾기
		// TODO 업무로직 구현체
		egovLogger.debug("컨트롤러에서 넘어온 값 : {}", params);
		egovLogger.debug("컨트롤러에서 넘어온 값 : {}", params);
		egovLogger.debug("컨트롤러에서 넘어온 값 : {}", params);
		
		HashMap<String, Object> result = member.selectMemberItem(params);
		egovLogger.debug("회원 정보 조회 : {}", result); //{}안에 변수의 값을 넣어줌 변수가 2개면 {}{}
		
		return result;
		
	}

}
