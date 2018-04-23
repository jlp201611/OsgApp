package egovframework.example.sample.web;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import egovframework.example.sample.service.MemberService;

@Controller
public class MemberController {
	
	@Resource(name="MemberService") //리소스는 빈을 지정해주고 오토와이어는 자동으로
	private MemberService member;
	
	private Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value="/loginView.do")
	public ModelAndView loginView(
			ModelAndView modelAndView,
			@RequestParam HashMap<String, Object> params
			) {
		
		modelAndView.setViewName("member/loginView");
		return modelAndView;
		
	}
	
	@RequestMapping(value="/loginViewProc.do")
	public ModelAndView loginViewProc(
			ModelAndView modelAndView,
			@RequestParam HashMap<String, Object> params,
			HttpServletRequest request,
			HttpServletResponse response
			) {

		System.out.println(params);
		
		try {
			HashMap<String, Object> loginInfo = member.selectMemberItem(params);

			if(StringUtils.isEmpty(loginInfo)){//로그인 성공
			//if(loginInfo == null || loginInfo.,equals("")){
				// TODO 로그인 실패
				throw new Exception("로그인 에러!! 아뒤 비번 확인 요망");
			}else {
				// TODO 로그인 성공
				request.getSession().setAttribute("session","로그인");
				request.getSession().setAttribute("loginInfo", loginInfo);
			}
			
			modelAndView.addObject("st",true);
			modelAndView.addObject("msg","로그인에 성공하셨습니다.");
			
		} catch (Exception e) {
			// TODO 로그인시 에러가 발생했을 경우
			e.printStackTrace();
			modelAndView.addObject("st",false);
			modelAndView.addObject("msg","로그인에 실패하셨습니다.");
		}
		modelAndView.setViewName("member/loginViewProc");
		return modelAndView;
	}
	
	@RequestMapping("/logut.do")
	public ModelAndView logut(ModelAndView modelAndView,@RequestParam HashMap<String, Object> params,HttpServletRequest request,
			HttpServletResponse response) {
		
		request.getSession().setAttribute("session", null);
		request.getSession().setAttribute("loginInfo", null);
		//리다이렉트 할경우
		RedirectView reView = new RedirectView();
		reView.setUrl("/loginView.do");
		modelAndView.setView(reView);
		
		return modelAndView;
		
	}
	
	
	
	
}
