package hu.bme.mit.swsv.cache.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import hu.bme.mit.swsv.cache.AbstractCache;

public class AbstractCacheTest {
	
	private class TestingCache extends AbstractCache<String,Integer> {}
	
	TestingCache cache = null;
	
	@Before
	public void setUp() {
		cache = new TestingCache();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPutNotForce() {		
		cache.put("apple", 5, false);
		cache.put("apple", 5, false);
	}
	
	@Test
	public void testPutWithForce() {
		cache.put("apple", 5, false);
		cache.put("apple", 10, true);
		
		Assert.assertEquals(10, ((Integer)cache.get("apple")).intValue());
	}
	
	@Test
	public void testSimplePut() {
		cache.put("apple", 10, false);
		
		Assert.assertEquals(10, ((Integer)cache.get("apple")).intValue());
	}
	
	@Test(timeout = 1000)
	@Ignore
	public void removeTimeout() {
		cache.remove("apple");
	}
}
