import org.apache.log4j.Logger;
import org.junit.Test;

public class logtest {

	Logger logger = Logger.getLogger(this.getClass());
	
	@Test
	public void testLog() {
		logger.info("Starting....");
		logger.debug("Very detailed log");
		logger.fatal("Terribly failing"); 
	    }
}

