//import org.apache.log4j.Logger;
import java.util.logging.Level;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

/**
  * Java program to configure log4j without using XML or properties file.
  * By using BasicConfigurator class, you can configure Log4j in one line.
  * @author
  */
public class Log4JConfigurator {
	//private static final Logger logger = Logger.getLogger(Log4JConfigurator.class);
  
    public static void main(String args[]) {
    	     
       /* BasicConfigurator.configure(); //enough for configuring log4j
        Logger.getRootLogger().setLevel(Level.DEBUG); //changing log level  
        logger.fatal("Fatal Message!");
        logger.error("Error Message!");
        logger.warn("Warnings,Message!");
        logger.info("Information Message!");
        logger.debug("Debugging Message !"); 
        logger.trace("Trace Message !");*/
        
        Logger logger = LoggerFactory.getLogger(Log4JConfigurator.class);
        BasicConfigurator.configure();
        final String message = "Hello logging!";
        logger.trace(message);
        logger.debug(message);
        logger.info(message);
        logger.warn(message);
        logger.error(message);
              
    }

  
}
 