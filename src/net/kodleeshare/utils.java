package net.kodleeshare;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class utils
{
	/**
	 * Encypts a string using SHA256 and a key
	 * 
	 * @param toEncrypt
	 *            A string to hash
	 * @return The hashed string
	 * @author Kodlee
	 */
	public static final String encrypt(String toEncrypt, String key)
	{
		StringBuffer enc = new StringBuffer();
		try
		{
			Mac mac = Mac.getInstance("HmacSHA256");
			SecretKeySpec secret = new SecretKeySpec(key.getBytes(), "HMacSHA256");
			mac.init(secret);
			byte[] digest = mac.doFinal(toEncrypt.getBytes());

			for (int i = 0; i < digest.length; i++)
			{
				String hex = Integer.toHexString(0xff & digest[i]);
				if (hex.length() == 1)
					enc.append('0');
				enc.append(hex);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return enc.toString();
	}
}
