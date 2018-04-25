package egovframework.example.mger;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class MagerController {

	@Resource(name = "MgerService") // 서비스 구현체의 서비스 변수명과 동일하게 해줘야함ㅎㅎㅎ
	private MgerService mger;

	private Logger log = LoggerFactory.getLogger(this.getClass()); // this는 현재의 파일명 // 스택틱인경우는 풀네임을 써줘야 한다 하지만 쓰지 않는다
																	// 성능저하 거의 없고 각 파일당 하나씩 파일로 로그를 기록하기때문에 스택틱 쓸일 없음

	@RequestMapping(value = { "/mgerList.do", "managerList"})
	public ModelAndView selectMger(ModelAndView modelView, @RequestParam HashMap<String, Object> params)
			throws Exception {

		log.info("인포");
		log.error("에러");
		log.debug("디버그");

		List<HashMap<String, Object>> reuslt = mger.selectMgerList(params); // 익셉션 발생 // 리스트에서는 오류뜰일이 거의 없어서 throws를 써움
																			// / 인서트등은 트라이캐치 쓰기
		modelView.addObject("reuslt", reuslt);

		// 실제 jsp파일을 연결해주는 준다

		modelView.setViewName("mger/selectMger");
		return modelView;
	}

	// 회원 가입폼
	@RequestMapping(value = "/mgerInsertFrom.do")
	public ModelAndView insertMger(ModelAndView modelView, @RequestParam HashMap<String, Object> params) {
		modelView.setViewName("mger/mgerInsertFrom");
		return modelView;
	}

	// 인서트
	@RequestMapping(value = "/mgerInsertProd.do", method = RequestMethod.POST)
	public ModelAndView mgerInsertProd(ModelAndView modelView, @RequestParam HashMap<String, Object> params) {

		log.debug("mgerInsertProd => {}", params);
		try {

			mger.insertMgerItem(params);
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl("/mgerList.do");
			modelView.setView(redirectView);

		} catch (Exception e) {
			// TODO 에러가 발생했을 경우 처리
			e.printStackTrace();
			modelView.setViewName("mger/mgerInsertFrom"); // setViewName(스트링), setView(오브젝트)
			log.error("에러=>" + e);
		}

		return modelView;
	}

	

	// 아이디 클릭 시 상세페이지
	@RequestMapping(value="/mgerView.do")
	public ModelAndView mgerView(ModelAndView modelView, @RequestParam HashMap<String, Object> params) throws Exception {
		log.debug("mgerView => {}",params);
		
		HashMap<String, Object> result = mger.selectMgerItem(params);
		log.debug("result => {}",result);
		modelView.addObject("result", result);
		
		modelView.setViewName("mger/mgerView");
		return modelView;

	}
	
	//수정페이지 폼
	@RequestMapping(value="/mgerUpdateForm.do")
	public ModelAndView mgerUpdate(ModelAndView modelAndView, @RequestParam HashMap<String, Object> params ) throws Exception {
		
		HashMap<String, Object> result= mger.selectMgerItem(params);
		modelAndView.addObject("result",result);
		
		modelAndView.setViewName("mger/mgerUpdateForm");
	
		return modelAndView;
	}

	
	@RequestMapping(value="/mgerUpdateProd.do")
	public ModelAndView mgerUpdateProd(ModelAndView modelAndView, @RequestParam HashMap<String, Object> params ) throws Exception  {
		log.debug("mgerUpdateProd =>{}",params);
		
		try {
			mger.updateMgerItem(params);
			
			RedirectView rev = new RedirectView();
			rev.setUrl(String.format("/mgerView.do?id=%s",	params.get("id")));
			modelAndView.setView(rev);
			
		} catch (Exception e) {
			// TODO 업데이트 실패
			modelAndView.addObject("message",e.getMessage());
			modelAndView.setViewName("mger/error");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value="/mgerDeleteProd.do")
	public ModelAndView mgerDeleteProd(ModelAndView modelAndView, @RequestParam HashMap<String, Object> params) throws Exception {
		
		try {
			log.debug("mgerDeleteProd => {}",params);
			
			mger.deleteMgerItem(params);
			RedirectView rdv = new RedirectView();
			rdv.setUrl("/mgerList.do");
			modelAndView.setView(rdv);
			
		} catch (Exception e) {
			// TODO 딜리트 실패
			modelAndView.addObject("message", e.getMessage());
			modelAndView.setViewName("mger/error");
		}
		
		return modelAndView;
	}


}

