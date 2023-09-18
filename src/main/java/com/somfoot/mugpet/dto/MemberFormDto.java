package com.somfoot.mugpet.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class MemberFormDto {

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min=8, max=16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요.")
    private String password;

    @NotEmpty(message = "닉네임은 필수 입력 값입니다.")
    private String nickname;    	//닉네임

    @NotEmpty(message = "이름은 필수 입력 값입니다.")
    private String name;        	//이름

    @Column(unique = true)
    @NotBlank(message = "이메일 필수 입력 값입니다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;        	//이메일(로그인할 아이디)

    @NotEmpty(message = "핸드폰 번호는 필수 입력 값입니다.")
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$",message = "핸드폰 번호의 양식과 맞지 않습니다. 01x-xxx(x)-xxxx")
    private String phoneNum;    	//전화번호

    @NotEmpty(message = "주소는 필수 입력 값입니다.")
    private String address;        	//주소

    private int point;            	//적립포인트

}