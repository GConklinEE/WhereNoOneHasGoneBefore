package whereNoOneHasGoneBefore.UnitTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.util.Vector;

import whereNoOneHasGoneBefore.Models.DeltaVMapSegment;
import whereNoOneHasGoneBefore.Models.Engine;
import whereNoOneHasGoneBefore.Models.ModelCollection;
import whereNoOneHasGoneBefore.Models.Rocket;
import whereNoOneHasGoneBefore.Models.Stage;

public class UnitTests {
	
	@Test
	void DeltaVMapTest() {
		fail("Not Implemented");
	}
	
	@Test
	void DeltaVMapSegmentTest() {
		String name = "Engine";
		boolean isDestination = true;
		boolean refuelAtEnd = false;
		double deltaV = 9000;
		double atmosphereLiftoffVacuumDeltaVCorrectionFactor = 0.9;
		
		try {
			new DeltaVMapSegment(name, isDestination, refuelAtEnd, 0, atmosphereLiftoffVacuumDeltaVCorrectionFactor);
			fail("Did not throw exception for illegal delta-V value!");
		} catch(Exception e) {}
		
		try {
			new DeltaVMapSegment(name, isDestination, refuelAtEnd, deltaV, 0);
			fail("Did not throw exception for illegal atmosphereLiftoffVacuumDeltaVCorrectionFactor value!");
		} catch(Exception e) {}
		
		try {
			new DeltaVMapSegment(name, isDestination, refuelAtEnd, deltaV, 1.1);
			fail("Did not throw exception for illegal atmosphereLiftoffVacuumDeltaVCorrectionFactor value!");
		} catch(Exception e) {}
		
		DeltaVMapSegment deltaVMapSegment = new DeltaVMapSegment(name, isDestination, refuelAtEnd, deltaV, atmosphereLiftoffVacuumDeltaVCorrectionFactor);
		
		assertEquals(name, deltaVMapSegment.getName(), "Name values did not match!");
		assertEquals(isDestination, deltaVMapSegment.getIsDestination(), "IsDestination values did not match!");
		assertEquals(refuelAtEnd, deltaVMapSegment.getRefuelAtEnd(), "RefuelAtEnd values did not match!");
		assertEquals(deltaV, deltaVMapSegment.getDeltaV(), 5, "Delta-V values did not match!");
		assertEquals(atmosphereLiftoffVacuumDeltaVCorrectionFactor, deltaVMapSegment.getAtmosphereLiftoffVacuumDeltaVCorrectionFactor(), 5, "AtmosphereLiftoffVacuumDeltaVCorrectionFactor values did not match!");
	}
	
	@Test
	void DeltaVMapSegmentGroupTest() {
		String name = "Engine";
		double mass = 1100;
		double vacuumISP = 350;
		double vacuumThrust = 25000;
		
		Engine engine = new Engine(name, mass, vacuumISP, vacuumThrust);
		
		assertEquals(name, engine.getName(), "Name values did not match!");
		assertEquals(mass, engine.getMass(), 5, "Mass values did not match!");
		assertEquals(vacuumISP, engine.getVacuumISP(), 5, "ISP values did not match!");
		assertEquals(vacuumThrust, engine.getVacuumThrust(), 5, "Thrust values did not match!");
		
		engine.setName(name + name);
		engine.setMass(mass*2);
		engine.setVacuumISP(vacuumISP*2);
		engine.setVacuumThrust(vacuumThrust*2);
		
		assertEquals(name + name, engine.getName(), "Name values did not match!");
		assertEquals(mass*2, engine.getMass(), 5, "Mass values did not match!");
		assertEquals(vacuumISP*2, engine.getVacuumISP(), 5, "ISP values did not match!");
		assertEquals(vacuumThrust*2, engine.getVacuumThrust(), 5, "Thrust values did not match!");
	}
	
	@Test
	void engineTest() {
		String name = "Engine";
		double mass = 1100;
		double vacuumISP = 350;
		double vacuumThrust = 25000;
		
		try {
			new Engine(name, -1, vacuumISP, vacuumThrust);
			fail("Did not throw exception for illegal mass value!");
		} catch(Exception e) {}
		
		try {
			new Engine(name, mass, 0, vacuumThrust);
			fail("Did not throw exception for illegal ISP value!");
		} catch(Exception e) {}
		
		try {
			new Engine(name, mass, vacuumISP, -1);
			fail("Did not throw exception for illegal thrust value!");
		} catch(Exception e) {}
		
		Engine engine = new Engine(name, mass, vacuumISP, vacuumThrust);
		
		try {
			engine.setMass(-1);
			fail("Did not throw exception for illegal mass value!");
		} catch(Exception e) {}
		
		try {
			engine.setVacuumISP(0);
			fail("Did not throw exception for illegal ISP value!");
		} catch(Exception e) {}
		
		try {
			engine.setVacuumThrust(-1);
			fail("Did not throw exception for illegal thrust value!");
		} catch(Exception e) {}
		
		assertEquals(name, engine.getName(), "Name values did not match!");
		assertEquals(mass, engine.getMass(), 5, "Mass values did not match!");
		assertEquals(vacuumISP, engine.getVacuumISP(), 5, "ISP values did not match!");
		assertEquals(vacuumThrust, engine.getVacuumThrust(), 5, "Thrust values did not match!");
		
		engine.setName(name + name);
		engine.setMass(mass*2);
		engine.setVacuumISP(vacuumISP*2);
		engine.setVacuumThrust(vacuumThrust*2);
		
		assertEquals(name + name, engine.getName(), "Name values did not match!");
		assertEquals(mass*2, engine.getMass(), 5, "Mass values did not match!");
		assertEquals(vacuumISP*2, engine.getVacuumISP(), 5, "ISP values did not match!");
		assertEquals(vacuumThrust*2, engine.getVacuumThrust(), 5, "Thrust values did not match!");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void modelCollectionTest() {
		String name = "ModelCollection";
		int expectedModels = 4;	
		Vector<Exception> m_oModelCollection = new Vector<Exception>();
		Exception exception = new Exception("E1");
		ModelCollection<Exception> modelCollection = new ModelCollection<Exception>(name);
		
		assertEquals(name, modelCollection.getName(), "Name values did not match!");
		
		modelCollection.setName(name + name);
		assertEquals(name + name, modelCollection.getName(), "Name values did not match!");
		
		try {
			modelCollection.addModel(null);
			fail("Did not throw exception for null model!");
		} catch(Exception e) {}
		
		try {
			modelCollection.deleteModel(null);
			fail("Did not throw exception for null model!");
		} catch(Exception e) {}
		
		try {
			modelCollection.deleteModel(new Exception("E"));
			fail("Did not throw exception for model not found!");
		} catch(Exception e) {}
		
		modelCollection.addModel(exception);
		modelCollection.addModel(new Exception("E2"));
		modelCollection.addModel(2, new Exception("E3"));
		modelCollection.addModel(0, new Exception("E4"));
		assertEquals(expectedModels, modelCollection.getNumModels(), "NumModels values did not match!");
	
		try {
			Field field = modelCollection.getClass().getDeclaredField("m_oModelCollection");
			field.setAccessible(true);
			m_oModelCollection = (Vector<Exception>)(field.get(modelCollection));
		} catch(Exception e) {
			fail("Reflection of model collection failed!");
		}
		assertEquals("E4", m_oModelCollection.elementAt(0).getMessage(), "Vector items not in correct order!");
		assertEquals("E1", m_oModelCollection.elementAt(1).getMessage(), "Vector items not in correct order!");
		assertEquals("E2", m_oModelCollection.elementAt(2).getMessage(), "Vector items not in correct order!");
		assertEquals("E3", m_oModelCollection.elementAt(3).getMessage(), "Vector items not in correct order!");
		
		modelCollection.deleteModel(exception);
		modelCollection.deleteModel(0);
		expectedModels = 2;
		assertEquals(expectedModels, modelCollection.getNumModels(), "NumModels values did not match!");
		assertEquals("E2", m_oModelCollection.elementAt(0).getMessage(), "Vector items not in correct order!");
		assertEquals("E3", m_oModelCollection.elementAt(1).getMessage(), "Vector items not in correct order!");
		
		modelCollection.clearModels(); 
		assertEquals(0, modelCollection.getNumModels(), "ModelCollection is not empty!");
	}
		
	@Test
	void rocketTest() {
		double engineMass = 1100;
		double vacuumISP = 350;
		double vacuumThrust = 25000;
		
		double stage1DryMass = 40000;
		double stage2DryMass = 50000;
		double stage1TotalMass = 80000;
		double stage2TotalMass = 100000;
		
		String name = "Rocket";
		double payloadMass = 2000;
		double expectedCurrentDryMass = stage1DryMass + stage2TotalMass + payloadMass;
		double expectedCurrentTotalMass = stage1TotalMass + stage2TotalMass + payloadMass;
		double expectedCurrentTotalThrust = vacuumThrust;
		double expectedCurrentAverageVacuumISP = vacuumISP;
		Rocket rocket;
		
		try {
			new Rocket(name, -1);
			fail("Did not throw exception for illegal payload value!");
		} catch(Exception e) {}
				
		rocket = new Rocket(name, payloadMass);
		
		assertEquals(name, rocket.getName(), "Name values did not match!");
		assertEquals(payloadMass, rocket.getCurrentDryMass(), 5, "CurrentDryMass values did not match!");
		assertEquals(payloadMass, rocket.getCurrentTotalMass(), 5, "CurrentTotalMass values did not match!");
		assertEquals(0, rocket.getCurrentTotalThrust(), 5, "CurrentTotalThrust values did not match!");
		assertEquals(0, rocket.getCurrentAverageVacuumISP(), 5, "CurrentAverageVacuumISP values did not match!");	
		assertEquals(payloadMass, rocket.getPayloadMass(), 5, "Payload mass values did not match!");	
		
		Stage stage1 = new Stage("Stage0", stage1DryMass, stage1TotalMass, true);
		stage1.addModel(new Engine("Engine", engineMass, vacuumISP, vacuumThrust));
		Stage stage2 = new Stage("Stage1", stage2DryMass, stage2TotalMass, true);
		stage2.addModel(new Engine("Engine", engineMass*2, vacuumISP*2, vacuumThrust*2));
		rocket.addModel(stage1);
		rocket.addModel(stage2);
		
		assertEquals(expectedCurrentDryMass, rocket.getCurrentDryMass(), 5, "CurrentDryMass values did not match!");
		assertEquals(expectedCurrentTotalMass, rocket.getCurrentTotalMass(), 5, "CurrentTotalMass values did not match!");
		assertEquals(expectedCurrentTotalThrust, rocket.getCurrentTotalThrust(), 5, "CurrentTotalThrust values did not match!");
		assertEquals(expectedCurrentAverageVacuumISP, rocket.getCurrentAverageVacuumISP(), 5, "CurrentAverageVacuumISP values did not match!");	
		assertEquals(payloadMass, rocket.getPayloadMass(), 5, "Payload mass values did not match!");	
		
		try {
			rocket.setPayloadMass(-1);
			fail("Did not throw exception for illegal payload value!");
		} catch(Exception e) {}
		
		rocket.setPayloadMass(payloadMass*2);
		assertEquals(payloadMass*2, rocket.getPayloadMass(), "Payload mass values do not match!");
		
		rocket.nextModel();
		expectedCurrentDryMass = stage2DryMass + payloadMass*2;
		expectedCurrentTotalMass = stage2TotalMass + payloadMass*2;
		expectedCurrentTotalThrust = vacuumThrust*2;
		expectedCurrentAverageVacuumISP = vacuumISP*2;
		assertEquals(expectedCurrentDryMass, rocket.getCurrentDryMass(), 5, "CurrentDryMass values did not match!");
		assertEquals(expectedCurrentTotalMass, rocket.getCurrentTotalMass(), 5, "CurrentTotalMass values did not match!");
		assertEquals(expectedCurrentTotalThrust, rocket.getCurrentTotalThrust(), 5, "CurrentTotalThrust values did not match!");
		assertEquals(expectedCurrentAverageVacuumISP, rocket.getCurrentAverageVacuumISP(), 5, "CurrentAverageVacuumISP values did not match!");	
		
		rocket.clearModels();
		assertEquals(payloadMass*2, rocket.getCurrentDryMass(), 5, "CurrentDryMass values did not match!");
		assertEquals(payloadMass*2, rocket.getCurrentTotalMass(), 5, "CurrentTotalMass values did not match!");
		assertEquals(0, rocket.getCurrentTotalThrust(), 5, "CurrentTotalThrust values did not match!");
		assertEquals(0, rocket.getCurrentAverageVacuumISP(), 5, "CurrentAverageVacuumISP values did not match!");	
	}	
	
	@Test
	void simulationResultTest() {
		fail("Not Implemented");
	}
	
	@Test
	void simulationResultGroupTest() {
		fail("Not Implemented");
	}	
	
	@Test
	void stageTest() {
		double engineMass = 1100;
		double vacuumISP = 350;
		double vacuumThrust = 25000;
		
		String name = "Stage";
		int numEngines = 9;
		double dryMass = 30000;
		double totalMass = 100000;
		boolean engineMassIncludedInStageMass = false;
		double expectedTotalMass = totalMass + numEngines * engineMass;
		double expectedAverageISP = (vacuumThrust*10) / ((vacuumThrust/vacuumISP)*7 + (3*vacuumThrust / (2*vacuumISP)));
		double expectedTotalVacuumThrust = (numEngines + 1) * vacuumThrust;
		Stage stage;

		try {
			new Stage(name, 0, totalMass, engineMassIncludedInStageMass);
			fail("Did not throw exception for illegal dry mass value!");
		} catch(Exception e) {}
		
		try {
			new Stage(name, dryMass, 0, engineMassIncludedInStageMass);
			fail("Did not throw exception for illegal total mass value!");
		} catch(Exception e) {}
		
		stage = new Stage(name, dryMass, totalMass, engineMassIncludedInStageMass);
		
		assertEquals(name, stage.getName(), "Name values did not match!");
		assertEquals(dryMass, stage.getDryMass(), 5, "Dry mass values did not match!");
		assertEquals(totalMass, stage.getTotalMass(), 5, "Total mass values did not match!");
		assertEquals(0, stage.getAverageVacuumISP(), 5, "Average ISP values did not match!");
		assertEquals(0, stage.getTotalVacuumThrust(), 5, "Total vacuum thrust values did not match!");
		assertEquals(engineMassIncludedInStageMass, stage.getEngineMassIncludedInStageMass(), "EngineMassIncludedInStageMass values did not match!");
					
		stage.addModel(new Engine("OddEngine0", engineMass*2, vacuumISP*2, vacuumThrust*3));
		stage.addModel(new Engine("OddEngine1", 0, vacuumISP*2, 0));
		for(int i = 0; i < numEngines - 2; i++) {
			stage.addModel(new Engine("Engine" + i, engineMass, vacuumISP, vacuumThrust));
		}
		
		try {
			stage.setDryMass(0);
			fail("Did not throw exception for illegal dry mass value!");
		} catch(Exception e) {}
		
		try {
			stage.setTotalMass(0);
			fail("Did not throw exception for illegal total mass value!");
		} catch(Exception e) {}
		
		assertEquals(dryMass, stage.getDryMass(), 5, "Dry mass values did not match!");
		assertEquals(expectedTotalMass, stage.getTotalMass(), 5, "Total mass values did not match!");
		assertEquals(expectedAverageISP, stage.getAverageVacuumISP(), 5, "Average ISP values did not match!");
		assertEquals(expectedTotalVacuumThrust, stage.getTotalVacuumThrust(), 5, "Total vacuum thrust values did not match!");
		assertEquals(engineMassIncludedInStageMass, stage.getEngineMassIncludedInStageMass(), "EngineMassIncludedInStageMass values did not match!");
			
		engineMassIncludedInStageMass = true;
		stage.setDryMass(dryMass*2);
		stage.setTotalMass(totalMass*2);
		stage.setEngineMassIncludedInStageMass(engineMassIncludedInStageMass);
	
		assertEquals(dryMass*2, stage.getDryMass(), 5, "Dry mass values did not match!");
		assertEquals(totalMass*2, stage.getTotalMass(), 5, "Total mass values did not match!");
		assertEquals(engineMassIncludedInStageMass, stage.getEngineMassIncludedInStageMass(), "EngineMassIncludedInStageMass values did not match!");
		
		stage.clearModels();
		expectedAverageISP = 0;
		expectedTotalVacuumThrust = 0;
		assertEquals(totalMass*2, stage.getTotalMass(), 5, "Total mass values did not match!");
		assertEquals(expectedAverageISP, stage.getAverageVacuumISP(), 5, "Average ISP values did not match!");
		assertEquals(expectedTotalVacuumThrust, stage.getTotalVacuumThrust(), 5, "Total vacuum thrust values did not match!");
	}
	
	@Test
	void stageGroupTest() {
		fail("Not Implemented");
	}
}
