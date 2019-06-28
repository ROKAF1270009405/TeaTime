package com.teatime.comm;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */
@WebFilter("/CharacterEncodingFilter")
public class CharacterEncodingFilter implements Filter {
	 
    //인코딩을 수행할 인코딩 캐릭터 셋 지정
    String encoding = "utf-8";
    
    //필터 설정 관리자
    FilterConfig filterConfig;
    
    /**
     * Default constructor. 
     */
    public CharacterEncodingFilter() {
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        //초기화
        //getInitParameter() : web.xml에 초기화해서 지정한 파라미터 값을 불러오는 메소드. 
        this.filterConfig = fConfig;
        this.encoding = fConfig.getInitParameter("encoding");
        if(fConfig.getInitParameter("encoding") ==null) {
        	this.encoding="utf-8";
        }
        System.out.println(fConfig.getInitParameter("encoding"));
        System.out.println("debug > init %%%%%%%%%eeeeeee");
    }    
    
    /**
     * @see Filter#destroy()
     */
    //destroy : 웹 애플리케이션이 끝날 때 같이 끝남
    public void destroy() {
        
        this.encoding = null;
        this.filterConfig = null;
        
//        System.out.println("debug > destroy %%%%%%%%%%%");
    }
 
    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
                throws IOException, ServletException {
 
        request.setCharacterEncoding("utf-8");
        
        if (request.getCharacterEncoding() == null) {
            if (encoding != null) 
                request.setCharacterEncoding(encoding);
        }
        chain.doFilter(request, response);
    }
}


