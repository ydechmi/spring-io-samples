package com.yd.jms.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jndi.JndiTemplate;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Class to fix connexion problem for secured JMS File
 */
public class UserCredentialsConnectionFactoryAdapter extends org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter {
    Logger logger= LoggerFactory.getLogger(UserCredentialsConnectionFactoryAdapter.class);
    private JndiTemplate jndiTemplate;

    public void setJndiTemplate(JndiTemplate jndiTemplate) {
        this.jndiTemplate = jndiTemplate;
    }

    @Override
    protected Connection doCreateConnection(String username, String password) throws JMSException {
        wlFix();
        return super.doCreateConnection(username, password);
    }

    /**
     * Associate JNDI variables (user and password) with this thread for the
     * benefit of the WL drivers.
     */
    protected void wlFix() {
        try {
            @SuppressWarnings("unused")
            InitialContext initialContext = new InitialContext(jndiTemplate.getEnvironment());
        } catch (NamingException e) {
            logger.error("Context initalisation error",e);
        }
    }

}
