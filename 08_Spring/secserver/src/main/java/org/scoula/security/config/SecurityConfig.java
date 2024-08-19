package org.scoula.security.config;

import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity  //모든 페이지에서 자동으로 인증을 하도록 설정
@Log4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    public void configure(HttpSecurity http) throws Exception {


// 경로별 접근 권한 설정
            http.authorizeRequests()
                    .antMatchers("/security/all").permitAll()
                    .antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
                    .antMatchers("/security/member").access("hasRole('ROLE_MEMBER')");

            http.formLogin(); // form 기반 로그인 활성화, 나머지는 모두 디폴트

        http.addFilterBefore(encodingFilter(), CsrfFilter.class);
        super.configure(http);
    }
    // 문자셋 필터
    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }
}