package whereNoOneHasGoneBefore.UnitTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.util.Vector;

import whereNoOneHasGoneBefore.Models.DeltaVMapSegment;
import whereNoOneHasGoneBefore.Models.DeltaVMapSegmentGroup;
import whereNoOneHasGoneBefore.Models.Engine;
import whereNoOneHasGoneBefore.Models.ModelCollection;
import whereNoOneHasGoneBefore.Models.Rocket;
import whereNoOneHasGoneBefore.Models.SimulationResult;
import whereNoOneHasGoneBefore.Models.SimulationResultGroup;
import whereNoOneHasGoneBefore.Models.Stage;

public class UnitTests {
	
	@Test
	void DeltaVMapTest() {
		fail("Not Implemented");
	}
	
	@Test
	void DeltaVMapSegmentTest() {
		String name = "DeltaVMapSegment";
		double gravityAtDestination = 5.5;
		double deltaVOutgoingWithAeroBraking = 5.7;
		double deltaVReturningWithAeroBraking = 2;
		double deltaVOutgoingWithoutAeroBraking = 6;
		double deltaVReturningWithoutAeroBraking = 9;
		double groundLevelISPCorrectionFactorOutgoing = 0.3;
		double groundLevelISPCorrectionFactorReturning = 0.5;
		double deltaVToVacuumISPValidOutgoing = 345;
		double deltaVToVacuumISPValidReturning = 450;
		double standardGravity = 9.80665;
		
		try {
			new DeltaVMapSegment(name, -1, deltaVOutgoingWithAeroBraking, deltaVReturningWithAeroBraking, deltaVOutgoingWithoutAeroBraking,
                    deltaVReturningWithoutAeroBraking, groundLevelISPCorrectionFactorOutgoing, groundLevelISPCorrectionFactorReturning,
                    deltaVToVacuumISPValidOutgoing, deltaVToVacuumISPValidReturning);
			fail("Did not throw exception for illegal gravityAtDestination value!");
		} catch(Exception e) {}
		
		try {
			new DeltaVMapSegment(name, gravityAtDestination, 0, deltaVReturningWithAeroBraking, deltaVOutgoingWithoutAeroBraking,
                    deltaVReturningWithoutAeroBraking, groundLevelISPCorrectionFactorOutgoing, groundLevelISPCorrectionFactorReturning,
                    deltaVToVacuumISPValidOutgoing, deltaVToVacuumISPValidReturning);
			fail("Did not throw exception for illegal deltaVOutgoingWithAeroBraking value!");
		} catch(Exception e) {}
		
		try {
			new DeltaVMapSegment(name, gravityAtDestination, deltaVOutgoingWithAeroBraking, 0, deltaVOutgoingWithoutAeroBraking,
                    deltaVReturningWithoutAeroBraking, groundLevelISPCorrectionFactorOutgoing, groundLevelISPCorrectionFactorReturning,
                    deltaVToVacuumISPValidOutgoing, deltaVToVacuumISPValidReturning);
			fail("Did not throw exception for illegal deltaVReturningWithAeroBraking value!");
		} catch(Exception e) {}
		
		try {
			new DeltaVMapSegment(name, gravityAtDestination, deltaVOutgoingWithAeroBraking, deltaVOutgoingWithoutAeroBraking, 0,
                    deltaVReturningWithoutAeroBraking, groundLevelISPCorrectionFactorOutgoing, groundLevelISPCorrectionFactorReturning,
                    deltaVToVacuumISPValidOutgoing, deltaVToVacuumISPValidReturning);
			fail("Did not throw exception for illegal deltaVOutgoingWithoutAeroBraking value!");
		} catch(Exception e) {}
		
		try {
			new DeltaVMapSegment(name, gravityAtDestination, deltaVOutgoingWithAeroBraking, deltaVOutgoingWithoutAeroBraking, deltaVOutgoingWithoutAeroBraking,
                    0, groundLevelISPCorrectionFactorOutgoing, groundLevelISPCorrectionFactorReturning,
                    deltaVToVacuumISPValidOutgoing, deltaVToVacuumISPValidReturning);
			fail("Did not throw exception for illegal deltaVReturningWithoutAeroBraking value!");
		} catch(Exception e) {}
		
		try {
			new DeltaVMapSegment(name, gravityAtDestination, deltaVOutgoingWithAeroBraking, deltaVOutgoingWithoutAeroBraking, deltaVOutgoingWithoutAeroBraking,
                    deltaVReturningWithoutAeroBraking, -1, groundLevelISPCorrectionFactorReturning,
                    deltaVToVacuumISPValidOutgoing, deltaVToVacuumISPValidReturning);
			fail("Did not throw exception for illegal groundLevelISPCorrectionFactorOutgoing value!");
		} catch(Exception e) {}
		
		try {
			new DeltaVMapSegment(name, gravityAtDestination, deltaVOutgoingWithAeroBraking, deltaVOutgoingWithoutAeroBraking, deltaVOutgoingWithoutAeroBraking,
                    deltaVReturningWithoutAeroBraking, 2, groundLevelISPCorrectionFactorReturning,
                    deltaVToVacuumISPValidOutgoing, deltaVToVacuumISPValidReturning);
			fail("Did not throw exception for illegal groundLevelISPCorrectionFactorOutgoing value!");
		} catch(Exception e) {}
		
		try {
			new DeltaVMapSegment(name, gravityAtDestination, deltaVOutgoingWithAeroBraking, deltaVOutgoingWithoutAeroBraking, deltaVOutgoingWithoutAeroBraking,
                    deltaVReturningWithoutAeroBraking, groundLevelISPCorrectionFactorOutgoing, -1,
                    deltaVToVacuumISPValidOutgoing, deltaVToVacuumISPValidReturning);
			fail("Did not throw exception for illegal groundLevelISPCorrectionFactorReturning value!");
		} catch(Exception e) {}
		
		try {
			new DeltaVMapSegment(name, gravityAtDestination, deltaVOutgoingWithAeroBraking, deltaVOutgoingWithoutAeroBraking, deltaVOutgoingWithoutAeroBraking,
                    deltaVReturningWithoutAeroBraking, groundLevelISPCorrectionFactorOutgoing, 2,
                    deltaVToVacuumISPValidOutgoing, deltaVToVacuumISPValidReturning);
			fail("Did not throw exception for illegal groundLevelISPCorrectionFactorReturning value!");
		} catch(Exception e) {}
		
		try {
			new DeltaVMapSegment(name, gravityAtDestination, deltaVOutgoingWithAeroBraking, deltaVOutgoingWithoutAeroBraking, deltaVOutgoingWithoutAeroBraking,
                    deltaVReturningWithoutAeroBraking, groundLevelISPCorrectionFactorOutgoing, groundLevelISPCorrectionFactorReturning,
                    -1, deltaVToVacuumISPValidReturning);
			fail("Did not throw exception for illegal deltaVToVacuumISPValidOutgoing value!");
		} catch(Exception e) {}
		
		try {
			new DeltaVMapSegment(name, gravityAtDestination, deltaVOutgoingWithAeroBraking, deltaVOutgoingWithoutAeroBraking, deltaVOutgoingWithoutAeroBraking,
                    deltaVReturningWithoutAeroBraking, groundLevelISPCorrectionFactorOutgoing, groundLevelISPCorrectionFactorReturning,
                    deltaVToVacuumISPValidOutgoing, -2);
			fail("Did not throw exception for illegal deltaVToVacuumISPValidReturning value!");
		} catch(Exception e) {}
		
		DeltaVMapSegment deltaVMapSegment = new DeltaVMapSegment(name, gravityAtDestination, deltaVOutgoingWithAeroBraking, deltaVReturningWithAeroBraking, deltaVOutgoingWithoutAeroBraking,
				                                                 deltaVReturningWithoutAeroBraking, groundLevelISPCorrectionFactorOutgoing, groundLevelISPCorrectionFactorReturning,
				                                                 deltaVToVacuumISPValidOutgoing, deltaVToVacuumISPValidReturning);
		
		assertEquals(name, deltaVMapSegment.getName(), "Name values did not match!");
		assertEquals(gravityAtDestination, deltaVMapSegment.getGravityAtDestination(), 5, "GravityAtDestination values did not match!");
		assertEquals(deltaVOutgoingWithAeroBraking, deltaVMapSegment.getDeltaV(true, true), "DeltaVOutgoingWithAeroBraking did not match!");
		assertEquals(deltaVReturningWithAeroBraking, deltaVMapSegment.getDeltaV(false, true), 5, "DeltaVReturningWithAeroBraking values did not match!");
		assertEquals(deltaVOutgoingWithoutAeroBraking, deltaVMapSegment.getDeltaV(true, false), 5, "DeltaVOutgoingWithoutAeroBraking values did not match!");
		assertEquals(deltaVReturningWithoutAeroBraking, deltaVMapSegment.getDeltaV(false, false), 5, "DeltaVReturningWithoutAeroBraking values did not match!");
		assertEquals(groundLevelISPCorrectionFactorOutgoing, deltaVMapSegment.getGroundLevelISPCorrectionFactor(true), 5, "GroundLevelISPCorrectionFactorOutgoing values did not match!");
		assertEquals(groundLevelISPCorrectionFactorReturning, deltaVMapSegment.getGroundLevelISPCorrectionFactor(false), 5, "GroundLevelISPCorrectionFactorReturning values did not match!");
		assertEquals(deltaVToVacuumISPValidOutgoing, deltaVMapSegment.getDeltaVToVacuumISPValid(true), 5, "DeltaVToVacuumISPValidOutgoing values did not match!");
		assertEquals(deltaVToVacuumISPValidReturning, deltaVMapSegment.getDeltaVToVacuumISPValid(false), 5, "DeltaVToVacuumISPValidReturning values did not match!");
		assertEquals(standardGravity, DeltaVMapSegment.STANDARD_GRAVITY, 5, "Standard gravity values did not match!");
	}
	
	@Test
	void DeltaVMapSegmentGroupTest() {
		String nameGroup = "DeltaVMapSegmentGroup";
		String nameSegment = "DeltaVMapSegment";
		double gravityAtDestination = 5.5;
		double deltaVOutgoingWithAeroBraking = 5.7;
		double deltaVReturningWithAeroBraking = 2;
		double deltaVOutgoingWithoutAeroBraking = 6;
		double deltaVReturningWithoutAeroBraking = 9;
		double groundLevelISPCorrectionFactorOutgoing = 0.3;
		double groundLevelISPCorrectionFactorReturning = 0.5;
		double deltaVToVacuumISPValidOutgoing = 345;
		double deltaVToVacuumISPValidReturning = 450;
		int deltaVMapSegment1Index = 0;
		int deltaVMapSegment2Index = 1;
		
		DeltaVMapSegment deltaVMapSegment1 = new DeltaVMapSegment(nameSegment, gravityAtDestination, deltaVOutgoingWithAeroBraking, deltaVReturningWithAeroBraking, deltaVOutgoingWithoutAeroBraking,
                												 deltaVReturningWithoutAeroBraking, groundLevelISPCorrectionFactorOutgoing, groundLevelISPCorrectionFactorReturning,
                												 deltaVToVacuumISPValidOutgoing, deltaVToVacuumISPValidReturning);
		
		DeltaVMapSegment deltaVMapSegment2 = new DeltaVMapSegment(nameSegment + nameSegment, gravityAtDestination*2, deltaVOutgoingWithAeroBraking*2, deltaVReturningWithAeroBraking*2, deltaVOutgoingWithoutAeroBraking*2,
				 deltaVReturningWithoutAeroBraking*2, groundLevelISPCorrectionFactorOutgoing*2, groundLevelISPCorrectionFactorReturning*2,
				 deltaVToVacuumISPValidOutgoing*2, deltaVToVacuumISPValidReturning*2);
		
		DeltaVMapSegmentGroup deltaVMapSegmentGroup = new DeltaVMapSegmentGroup(nameGroup);
		deltaVMapSegmentGroup.addModel(deltaVMapSegment1);
		deltaVMapSegmentGroup.addModel(deltaVMapSegment2);
		
		assertEquals(nameGroup, deltaVMapSegmentGroup.getName(), "DeltaVMapSegmentGroup name values did not match!");
		
		assertEquals(nameSegment, deltaVMapSegmentGroup.getSegmentNameByIndex(deltaVMapSegment1Index), "DeltaVMapSegment name values did not match!");
		assertEquals(gravityAtDestination, deltaVMapSegmentGroup.getSegmentGravityAtDestinationByIndex(deltaVMapSegment1Index), 5, "GravityAtDestination values did not match!");
		assertEquals(deltaVOutgoingWithAeroBraking, deltaVMapSegmentGroup.getSegmentDeltaVByIndex(deltaVMapSegment1Index, true, true), "DeltaVOutgoingWithAeroBraking did not match!");
		assertEquals(deltaVReturningWithAeroBraking, deltaVMapSegmentGroup.getSegmentDeltaVByIndex(deltaVMapSegment1Index, false, true), 5, "DeltaVReturningWithAeroBraking values did not match!");
		assertEquals(deltaVOutgoingWithoutAeroBraking, deltaVMapSegmentGroup.getSegmentDeltaVByIndex(deltaVMapSegment1Index, true, false), 5, "DeltaVOutgoingWithoutAeroBraking values did not match!");
		assertEquals(deltaVReturningWithoutAeroBraking, deltaVMapSegmentGroup.getSegmentDeltaVByIndex(deltaVMapSegment1Index, false, false), 5, "DeltaVReturningWithoutAeroBraking values did not match!");
		assertEquals(groundLevelISPCorrectionFactorOutgoing, deltaVMapSegmentGroup.getSegmentGroundLevelISPCorrectionFactorByIndex(deltaVMapSegment1Index, true), 5, "GroundLevelISPCorrectionFactorOutgoing values did not match!");
		assertEquals(groundLevelISPCorrectionFactorReturning, deltaVMapSegmentGroup.getSegmentGroundLevelISPCorrectionFactorByIndex(deltaVMapSegment1Index, false), 5, "GroundLevelISPCorrectionFactorReturning values did not match!");
		assertEquals(deltaVToVacuumISPValidOutgoing, deltaVMapSegmentGroup.getSegmentDeltaVToVacuumISPValidByIndex(deltaVMapSegment1Index, true), 5, "DeltaVToVacuumISPValidOutgoing values did not match!");
		assertEquals(deltaVToVacuumISPValidReturning, deltaVMapSegmentGroup.getSegmentDeltaVToVacuumISPValidByIndex(deltaVMapSegment1Index, false), 5, "DeltaVToVacuumISPValidReturning values did not match!");
		
		assertEquals(nameSegment + nameSegment, deltaVMapSegmentGroup.getSegmentNameByIndex(deltaVMapSegment2Index), "DeltaVMapSegment name values did not match!");
		assertEquals(gravityAtDestination*2, deltaVMapSegmentGroup.getSegmentGravityAtDestinationByIndex(deltaVMapSegment2Index), 5, "GravityAtDestination values did not match!");
		assertEquals(deltaVOutgoingWithAeroBraking*2, deltaVMapSegmentGroup.getSegmentDeltaVByIndex(deltaVMapSegment2Index, true, true), "DeltaVOutgoingWithAeroBraking did not match!");
		assertEquals(deltaVReturningWithAeroBraking*2, deltaVMapSegmentGroup.getSegmentDeltaVByIndex(deltaVMapSegment2Index, false, true), 5, "DeltaVReturningWithAeroBraking values did not match!");
		assertEquals(deltaVOutgoingWithoutAeroBraking*2, deltaVMapSegmentGroup.getSegmentDeltaVByIndex(deltaVMapSegment2Index, true, false), 5, "DeltaVOutgoingWithoutAeroBraking values did not match!");
		assertEquals(deltaVReturningWithoutAeroBraking*2, deltaVMapSegmentGroup.getSegmentDeltaVByIndex(deltaVMapSegment2Index, false, false), 5, "DeltaVReturningWithoutAeroBraking values did not match!");
		assertEquals(groundLevelISPCorrectionFactorOutgoing*2, deltaVMapSegmentGroup.getSegmentGroundLevelISPCorrectionFactorByIndex(deltaVMapSegment2Index, true), 5, "GroundLevelISPCorrectionFactorOutgoing values did not match!");
		assertEquals(groundLevelISPCorrectionFactorReturning*2, deltaVMapSegmentGroup.getSegmentGroundLevelISPCorrectionFactorByIndex(deltaVMapSegment2Index, false), 5, "GroundLevelISPCorrectionFactorReturning values did not match!");
		assertEquals(deltaVToVacuumISPValidOutgoing*2, deltaVMapSegmentGroup.getSegmentDeltaVToVacuumISPValidByIndex(deltaVMapSegment2Index, true), 5, "DeltaVToVacuumISPValidOutgoing values did not match!");
		assertEquals(deltaVToVacuumISPValidReturning*2, deltaVMapSegmentGroup.getSegmentDeltaVToVacuumISPValidByIndex(deltaVMapSegment2Index, false), 5, "DeltaVToVacuumISPValidReturning values did not match!");
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
		Vector<Exception> m_oModelCollectionReflection = new Vector<Exception>();
		Vector<Exception> models = new Vector<Exception>();
		Exception exception = new Exception("E1");
		ModelCollection<Exception> modelCollection = new ModelCollection<Exception>(name);
		
		assertEquals(name, modelCollection.getName(), "Name values did not match!");
		
		modelCollection.setName(name + name);
		assertEquals(name + name, modelCollection.getName(), "Name values did not match!");
		
		modelCollection.addModel(exception);
		modelCollection.addModel(new Exception("E2"));
		modelCollection.addModel(2, new Exception("E3"));
		modelCollection.addModel(0, new Exception("E4"));
		assertEquals(expectedModels, modelCollection.getNumModels(), "NumModels values did not match!");
	
		try {
			Field field = modelCollection.getClass().getDeclaredField("m_oModelCollection");
			field.setAccessible(true);
			m_oModelCollectionReflection = (Vector<Exception>)(field.get(modelCollection));
		} catch(Exception e) {
			fail("Reflection of model collection failed!");
		}
		assertEquals("E4", m_oModelCollectionReflection.elementAt(0).getMessage(), "Vector items not in correct order!");
		assertEquals("E1", m_oModelCollectionReflection.elementAt(1).getMessage(), "Vector items not in correct order!");
		assertEquals("E2", m_oModelCollectionReflection.elementAt(2).getMessage(), "Vector items not in correct order!");
		assertEquals("E3", m_oModelCollectionReflection.elementAt(3).getMessage(), "Vector items not in correct order!");
		
		modelCollection.deleteModel(exception);
		modelCollection.deleteModel(0);
		expectedModels = 2;
		assertEquals(expectedModels, modelCollection.getNumModels(), "NumModels values did not match!");
		assertEquals("E2", m_oModelCollectionReflection.elementAt(0).getMessage(), "Vector items not in correct order!");
		assertEquals("E3", m_oModelCollectionReflection.elementAt(1).getMessage(), "Vector items not in correct order!");
		
		modelCollection.replaceModel(0, exception);
		assertEquals("E1", m_oModelCollectionReflection.elementAt(0).getMessage(), "Vector items not in correct order!");
		
		modelCollection.clearModels(); 
		assertEquals(0, modelCollection.getNumModels(), "ModelCollection is not empty!");
		
		models.add(exception);
		modelCollection.setModelCollection(models);
		assertEquals("E1", m_oModelCollectionReflection.elementAt(0).getMessage(), "Vector items not in correct order!");
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
		String name = "Mars";
		double maxPayloadOutgoing = 45.7;
		double maxPayloadReturning = 234.9;
		
		SimulationResult simulationResult = new SimulationResult(name);
		
		try {
			simulationResult.setMaxPayload(-1, true);
			fail("Did not throw exception for illegal maxPayload value!");
		} catch(Exception e) {}
		
		try {
			simulationResult.setMaxPayload(-1, false);
			fail("Did not throw exception for illegal maxPayload value!");
		} catch(Exception e) {}
		
		assertEquals(name, simulationResult.getDestinationName(), "DestinationName values did not match!");
		
		simulationResult.setMaxPayload(maxPayloadOutgoing, true);
		simulationResult.setMaxPayload(maxPayloadReturning, false);
		
		assertEquals(maxPayloadOutgoing, simulationResult.getMaxPayload(true), 5, "MaxPayloadOutgoing values did not match!");
		assertEquals(maxPayloadReturning, simulationResult.getMaxPayload(false), 5, "MaxPayloadReturning values did not match!");
	}
	
	@Test
	void simulationResultGroupTest() {
		String nameGroup = "SimResults";
		String nameResult = "Mars";
		double maxPayloadOutgoing = 45.7;
		double maxPayloadReturning = 234.9;
		int simulationResult1Index = 0;
		int simulationResult2Index = 1;
		
		SimulationResult simulationResult1 = new SimulationResult(nameResult);
		SimulationResult simulationResult2 = new SimulationResult(nameResult + nameResult);
		
		SimulationResultGroup simulationResultGroup = new SimulationResultGroup(nameGroup);
		simulationResultGroup.addModel(simulationResult1);
		simulationResultGroup.addModel(simulationResult2);
		
		simulationResultGroup.setMaxPayloadByIndex(simulationResult1Index, maxPayloadOutgoing, true);
		simulationResultGroup.setMaxPayloadByIndex(simulationResult1Index, maxPayloadReturning, false);
		simulationResultGroup.setMaxPayloadByIndex(simulationResult2Index, maxPayloadOutgoing*2, true);
		simulationResultGroup.setMaxPayloadByIndex(simulationResult2Index, maxPayloadReturning*2, false);
		
		assertEquals(nameGroup, simulationResultGroup.getName(), "SimulationResultGroup name values did not match!");
		
		assertEquals(nameResult, simulationResultGroup.getDestinationNameByIndex(simulationResult1Index), "SimulationResult name values did not match!");
		assertEquals(nameResult + nameResult, simulationResultGroup.getDestinationNameByIndex(simulationResult2Index), "SimulationResult name values did not match!");
		assertEquals(maxPayloadOutgoing, simulationResultGroup.getMaxPayloadByIndex(simulationResult1Index, true), 5, "MaxPayloadOutgoing did not match!");
		assertEquals(maxPayloadReturning, simulationResultGroup.getMaxPayloadByIndex(simulationResult1Index, false), 5, "MaxPayloadReturning values did not match!");
		assertEquals(maxPayloadOutgoing*2, simulationResultGroup.getMaxPayloadByIndex(simulationResult2Index, true), 5, "MaxPayloadOutgoing values did not match!");
		assertEquals(maxPayloadReturning*2, simulationResultGroup.getMaxPayloadByIndex(simulationResult2Index, false), 5, "MaxPayloadReturning values did not match!");
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
