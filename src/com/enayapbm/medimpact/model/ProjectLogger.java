package com.enayapbm.medimpact.model;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectLogger {

	private static Logger logB = Logger.getLogger("logBasic");
	private static Logger logX = Logger.getLogger("logXML");
	private static Logger logE = Logger.getLogger("logException");

	static {
		logB.info("initialization message for logBasic");
		logX.info("initialization message for logXml");
		logE.info("initialization message for logException");
	}

	public static void logBasic(String info, Level level, Throwable ex) {
		logB.log(level, info, ex);
	}

	public static void logBasic(String info) {
		logB.log(Level.INFO, info);
	}

	public static void logXml(String info, Level level, Throwable ex) {
		logX.log(level, info, ex);
	}

	public static void logException(String info, Level level, Throwable ex) {
		logE.log(level, info, ex);
	}

	public static void logException(String info) {
		logE.log(Level.INFO, info);
	}
	
	public static String getStackTrace(Throwable t)
	{
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		pw.flush();
		return sw.toString();
	}
}
