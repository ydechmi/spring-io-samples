/**
 * 
 */
package com.yd.jms.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


public class MyJmsListener implements MessageListener {

	final Logger logger = LoggerFactory.getLogger(MyJmsListener.class);

	/**
	 * Default constructor
	 */
	public MyJmsListener() {
		logger.info("Create listener instance");
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	public void onMessage(Message message) {
		logger.info("Start Listener");
		if(null!=message){
			TextMessage textMessage=(TextMessage) message;
			try {
				logger.info("Message:" + textMessage.getText());
			} catch (JMSException e) {
				logger.error("onMessage error", e);
			}
		}
		logger.info("End Listener");
	}

	

}
