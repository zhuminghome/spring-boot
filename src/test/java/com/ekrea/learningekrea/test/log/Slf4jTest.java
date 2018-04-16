package com.ekrea.learningekrea.test.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @author zming.BlueOcean 
* @date 创建时间：2018年4月16日 下午2:20:53 
* @version 1.0 
* @description 
*/
public class Slf4jTest {
	private static Logger logger = LoggerFactory.getLogger(Slf4jTest.class);
	        public static void main(String[] args) {
//	        	Logger logger = LoggerFactory.getLogger(Object.class);
        	    logger.trace("=====trace=====");  
	  	        logger.debug("=====debug=====");  
	  	        logger.info("=====info=====");  
	  	        logger.warn("=====warn=====");  
	  	        logger.error("=====error=====");  
			}
	      
}
