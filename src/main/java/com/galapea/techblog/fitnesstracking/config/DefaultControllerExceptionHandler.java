package com.galapea.techblog.fitnesstracking.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class DefaultControllerExceptionHandler {

	@ExceptionHandler(value = NotFoundException.class)
	public ModelAndView notFoundErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		final String message = e.getMessage() != null ? e.getMessage() : "";
		log.error(message, e);
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error/404");
		return mav;
	}

	@ExceptionHandler(value = NoResourceFoundException.class)
	public ModelAndView noResourceFoundExceptionErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		final String message = e.getMessage() != null ? e.getMessage() : "";
		log.error("No static resource");
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error/500");
		return mav;
	}

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		final String message = e.getMessage() != null ? e.getMessage() : "";
		log.error(message, e);
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error/500");
		return mav;
	}

}
