package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity) {		
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.

				try {
					// we use MD5 with 128 bits digest
					MessageDigest md = MessageDigest.getInstance("MD5");

					// compute the hash of the input 'entity'
					byte[] digest = md.digest(entity.getBytes("utf8"));

					// convert the hash into hex format
					String hashvalue = toHex(digest);

					// convert the hex into BigInteger
					hashint = new BigInteger(hashvalue, 16);

				} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// return the BigInteger
				return hashint;
			}
	
public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		// get the digest length
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			int length = md.getDigestLength();
			int numBit = length * 8;
			BigInteger svar = new BigInteger("2").pow(numBit);
			return svar;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		// compute the number of bits = digest length * 8
		
		// compute the address size = 2 ^ number of bits
		
		// return the address size
		
		
	}
	
public static int bitSize() {
	
	int digestlen = 0;
	try {
		digestlen = MessageDigest.getInstance("MD5").getDigestLength();
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	// find the digest length
	
	return digestlen*8;
}

public static String toHex(byte[] digest) {
	StringBuilder strbuilder = new StringBuilder();
	for(byte b : digest) {
		strbuilder.append(String.format("%02x", b&0xff));
	}
	return strbuilder.toString();
}

}
