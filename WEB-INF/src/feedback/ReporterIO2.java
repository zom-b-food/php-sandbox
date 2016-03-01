package feedback;

import java.io.*;
import java.util.*;


public class ReporterIO2 {
	public synchronized static void addRecord(Reporter2 reporter2, String fileName) throws IOException {
		File file = new File(fileName);
		PrintWriter out = new PrintWriter(new FileWriter(file, true));
		out.println(reporter2.getIP() + "|"
				            + reporter2.getNAME() + "|"
				            + reporter2.getHOST() + "\r");

		out.close();
	}

	public static Reporter2 getReporter2(String add2, String fileName) throws IOException {
		File file = new File(fileName);
		BufferedReader in = new BufferedReader(new FileReader(file));
		Reporter2 reporter2 = new Reporter2();
		String line = in.readLine();
		while (line != null) {
			StringTokenizer t = new StringTokenizer(line, "|");
			String bubba = t.nextToken();
			if (bubba.equalsIgnoreCase(add2)) {
				String clientIP = t.nextToken();
				String clientHost = t.nextToken();
				String localName = t.nextToken();
				reporter2.setIP(clientIP);
				reporter2.setHOST(clientHost);
				reporter2.setNAME(localName);
			}
			line = in.readLine();
		}
		in.close();
		return reporter2;
	}

	public synchronized static Vector readRecords(String file) throws IOException {
		Vector reporters2 = new Vector();
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = in.readLine();
		while (line != null) {
			StringTokenizer t = new StringTokenizer(line, "|");
			String clientIP = t.nextToken();
			String clientHost = t.nextToken();
			String localName = t.nextToken();
			Reporter2 reporter2 = new Reporter2(clientIP, clientHost, localName);
			reporters2.add(reporter2);
			line = in.readLine();
		}
		in.close();
		return reporters2;
	}
}
