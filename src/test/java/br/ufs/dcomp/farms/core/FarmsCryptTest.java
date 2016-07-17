package br.ufs.dcomp.farms.core;

import org.junit.Test;

import junit.framework.TestCase;

public class FarmsCryptTest extends TestCase {

	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void testHashPasswordShouldHashAPassword() {
		String dsPassword = "12345678";
		
		String dsHashedPassword = FarmsCrypt.hashPassword(dsPassword);
		
		assertNotNull(dsHashedPassword);
		assertNotSame(dsPassword, dsHashedPassword);
	}

	@Test
	public void testCheckPasswordShouldCheckHashedPassword() {
		String dsPasswordWithoutHash = "12345678";
		String dsHashedPassword = "$2a$12$CS1qy9EThv.ieNZ9Vmz9iuZp9pzk5I3MblNVKUqgiXqmgS4e9XR.y";
		
		boolean result = FarmsCrypt.checkPassword(dsPasswordWithoutHash, dsHashedPassword);
		
		assertTrue(result);
	}
}
