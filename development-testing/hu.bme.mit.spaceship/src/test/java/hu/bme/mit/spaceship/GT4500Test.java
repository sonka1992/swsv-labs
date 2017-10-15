package hu.bme.mit.spaceship;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class GT4500Test {

	@Mock
	private TorpedoStore primaryTorpedoStore;
	
	@Mock
	private TorpedoStore secondaryTorpedoStore;
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	private GT4500 ship;	
	
	@Before
	public void init(){	
		this.ship = new GT4500();
		this.ship.setPrimaryTorpedoStore(primaryTorpedoStore);
		this.ship.setSecondaryTorpedoStore(secondaryTorpedoStore);
	}
		
	@Test
	public void fireTorpedos_All_Success(){
		ship.fireTorpedos(FiringMode.ALL);
		
		verify(primaryTorpedoStore).isEmpty();
		verify(primaryTorpedoStore).fire(1);
		
		verify(secondaryTorpedoStore).isEmpty();
		verify(secondaryTorpedoStore).fire(1);
	}
	
}
