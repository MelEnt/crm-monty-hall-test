package se.comhem.test.montyhall;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import se.comhem.test.montyhall.controller.SimulatorController;
import se.comhem.test.montyhall.enums.SimulationOutputFields;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MontyHallApplicationTests {
	
	static SimulatorController simController;
	
	@Before
	public void init() {
		simController = new SimulatorController();
	}
	
	@Test
	public void contextLoads() {
	}
	
	@Test(expected = InternalError.class)
	public void throwsInternalErrorOnNoSimulationInput() throws Exception {
		Map<String, Object> input = new HashMap<>();
		input.put(SimulationOutputFields.NUM_OF_SIMS.getString(), 0);
		input.put(SimulationOutputFields.WILL_SWAP_DOOR.getString(), true);
		
		simController.postSimulation(input);
	}
	
	@Test(expected = InternalError.class)
	public void throwsInternalErrorOnNoBooleanInput() throws Exception {
		Map<String, Object> input = new HashMap<>();
		input.put(SimulationOutputFields.NUM_OF_SIMS.getString(), 10);
		input.put(SimulationOutputFields.WILL_SWAP_DOOR.getString(), null);
		
		simController.postSimulation(input);
	}

}
