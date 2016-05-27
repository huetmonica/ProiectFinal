package Repository;

import java.security.MessageDigest;

public class MD5Digest {

	public String Criptare(String parolav) throws Exception {

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(parolav.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}

}