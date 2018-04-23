package egovframework.example.sample.service.impl;

import java.util.HashMap;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("egovframework.example.sample.service.impl.MemberMapper")
public interface MemberMapper {
	
	public HashMap<String, Object> selectMemberItem(HashMap<String, Object> parmas) throws Exception;
	
}
