package com.gdu.rest.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.rest.domain.MemberDTO;

@Mapper
public interface MemberMapper {
	public int insertMember(MemberDTO member);
}
