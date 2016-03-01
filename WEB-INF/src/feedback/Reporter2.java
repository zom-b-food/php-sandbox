package feedback;

public class Reporter2 {
	private String clientHost;
	private String clientIP;
	private String localName;

	public Reporter2() {}

	public Reporter2(String one, String two, String three) {
		clientHost = one;
		clientIP = two;
		localName = three;
	}

	public void setHOST(String f) {
		clientHost = f;
	}
    public String getHOST() { return clientHost; }

	public void setIP(String l) {
		clientIP = l;
	}
    public String getIP() { return clientIP; }

	public void setNAME(String e) {
		localName = e;
	}
    public String getNAME() { return localName; }
}
