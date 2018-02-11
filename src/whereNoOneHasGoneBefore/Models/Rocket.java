package whereNoOneHasGoneBefore.Models;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

// This class isn't done yet, methods are copy/pasted in from the StageGroup class.

public class Rocket extends SimulationModelCollection<StageGroup> implements Serializable {

	// Constructors
	
	public Rocket(String name) {
		super(name);
		m_dPayloadMass = 0;
		calculateStats();
	}
	
	// Methods
	
	public double getCurrentDryMass() { // Dry mass of current stage + total mass of all other unseparated stages + payload
		return m_dCurrentDryMass;
	}
	
	public double getCurrentTotalMass() { // All non-separated stages + payload  
		return m_dCurrentTotalMass;
	}
	
	public double getCurrentTotalThrust() { // Current stage
		return m_dCurrentTotalVacuumThrust;
	}
	
	public double getCurrentAverageVacuumISP() { // Current stage
		return m_dCurrentAverageVacuumISP;
	}
		
	public double getPayloadMass() {
		return m_dPayloadMass;
	}
	
	public void setPayloadMass(double payloadMass) {
		if (payloadMass < 0) {
			throw new NullPointerException("Rocket.setPayloadMass: Invalid payloadMass value!");
		} else {
			m_dPayloadMass = payloadMass;
			calculateStats();
		}
	}
		
	protected void rewindStats() {
		reset_burnTime on all stage groups// burn time left is reset on all stages, cores, and boosters. );
	}
	
	protected void calculateStats() {
		m_dCurrentDryMass = m_dPayloadMass;
		m_dCurrentTotalMass = m_dPayloadMass;
		m_dCurrentTotalThrust = 0;
		m_dCurrentAverageVacuumISP = 0;
		
		for(int modelIndex = 0; modelIndex < m_oModelCollection.size(); modelIndex++) {
			if(!isCompletedModel(modelIndex)) { // Unseparated stages
				m_dCurrentTotalMass += m_oModelCollection.elementAt(modelIndex).getTotalMass();
				if(isActiveModel(modelIndex)) { // Active stage
					m_dCurrentDryMass += m_oModelCollection.elementAt(modelIndex).getDryMass();
				} else {
					m_dCurrentDryMass += m_oModelCollection.elementAt(modelIndex).getTotalMass();
				}
			}
		}
				
		if(m_iCurrentModel < m_oModelCollection.size()) { // If there are unseparated stages left
			m_dCurrentTotalThrust = m_oModelCollection.elementAt(m_iCurrentModel).getTotalVacuumThrust();
			m_dCurrentAverageVacuumISP = m_oModelCollection.elementAt(m_iCurrentModel).getAverageVacuumISP();
		}
		
		rewindStats
	}
		
	public String getEngineNameByIndex(int stageIndex, int engineIndex) {
		return m_oModelCollection.elementAt(stageIndex).getEngineNameByIndex(engineIndex);
	}
	
	public double getEngineMassByIndex(int stageIndex, int engineIndex) {
		return m_oModelCollection.elementAt(stageIndex).getEngineMassByIndex(engineIndex);
	}
	
	public double getEngineVacuumISPByIndex(int stageIndex, int engineIndex) {
		return m_oModelCollection.elementAt(stageIndex).getEngineVacuumISPByIndex(engineIndex);
	}
	
	public double getEngineVacuumThrustByIndex(int stageIndex, int engineIndex) {
		return m_oModelCollection.elementAt(stageIndex).getEngineVacuumThrustByIndex(engineIndex);
	}
		
	public double getStageDryMassByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getDryMass();
	}
	
	public double getStageCurrentTotalMassByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getCurrentTotalMass();
	}
	
	public double getStageTotalVacuumThrustByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getTotalVacuumThrust();
	}
	
	public double getStageAverageVacuumISPByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getAverageVacuumISP();
	}	
	
	public double getBurnTimeLeftByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getBurnTimeLeft();
	}
		
	public boolean getEngineMassIncludedInStageMassByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getEngineMassIncludedInStageMass();
	}
	
	public boolean getIsMainStageByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getIsMainStage();
	}
	
	public boolean getIsSeperatedByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getIsSeperated();
	}
	
	public boolean getCanAerobrakeAtDestinationByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getCanAerobrakeAtDestination();
	}
	
	public boolean getCanLaunchAtDestinationByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getCanLaunchAtDestination();
	}
	
	public boolean getCanLandAtDestinationByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getCanLandAtDestination();
	}
	
	public boolean getIsReusableByIndex(int stageIndex) {
		return m_oModelCollection.elementAt(stageIndex).getIsReusable();
	}
	
	public int getMainStageIndex() {
		return m_iMainStageIndex;
	}
	
	public double getCurrentStageGroupTotalMass() {
		double stageGroupTotalMass = 0;
		Iterator<Stage> stages = m_oModelCollection.iterator();
	    while(stages.hasNext()) {
	    	Stage stage = stages.next();
	    	if(!stage.getIsSeperated()) {
	    		stageGroupTotalMass += stage.getCurrentTotalMass();
	    	}
	    }
	    return stageGroupTotalMass;
	}

	public double getCurrentStageGroupTotalVacuumThrust() {
		double stageGroupTotalVacuumThrust = 0;
		Iterator<Stage> stages = m_oModelCollection.iterator();
	    while(stages.hasNext()) {
	    	Stage stage = stages.next();
	    	if(!stage.getIsSeperated()) {
	    		stageGroupTotalVacuumThrust += stage.getTotalVacuumThrust();
	    	}
	    }
	    return stageGroupTotalVacuumThrust;
	}
	
	public double getCurrentStageGroupAverageVacuumISP() {
		double stageGroupTotalVacuumThrust = 0;
		double stageGroupAverageVacuumISPDenominator = 0;
		Iterator<Stage> stages = m_oModelCollection.iterator();
	    while(stages.hasNext()) {
	    	Stage stage = stages.next();
	    	if(!stage.getIsSeperated()) {
	    		stageGroupTotalVacuumThrust += stage.getTotalVacuumThrust();
	    		stageGroupAverageVacuumISPDenominator += stage.getTotalVacuumThrust() / stage.getAverageVacuumISP();
	    	}
	    }
	    return stageGroupTotalVacuumThrust / stageGroupAverageVacuumISPDenominator;
	}
				
	public void setEngineNameByIndex(int stageIndex, int engineIndex, String name) {
		m_oModelCollection.elementAt(stageIndex).setName(name);
	}
	
	public void setEngineMassByIndex(int stageIndex, int engineIndex, double mass) {
		m_oModelCollection.elementAt(stageIndex).setEngineMassByIndex(engineIndex, mass);
		resetStageBurnTimes();
	}
	
	public void setEngineVacuumISPByIndex(int stageIndex, int engineIndex, double vacuumISP) {
		m_oModelCollection.elementAt(stageIndex).setEngineVacuumISPByIndex(engineIndex, vacuumISP);
		resetStageBurnTimes();
	}
	
	public void setEngineVacuumThrustByIndex(int stageIndex, int engineIndex, double vacuumThrust) {
		m_oModelCollection.elementAt(stageIndex).setEngineVacuumThrustByIndex(engineIndex, vacuumThrust);
		resetStageBurnTimes();
	}	
	
	public void setStageDryMassByIndex(int stageIndex, double dryMass) {
		m_oModelCollection.elementAt(stageIndex).setDryMass(dryMass);
		resetStageBurnTimes();
	}
	
	public void setStageTotalMassByIndex(int stageIndex, double totalMass) {
		m_oModelCollection.elementAt(stageIndex).setTotalMass(totalMass);
		resetStageBurnTimes();
	}
		
	public void setEngineMassIncludedInStageMassByIndex(int stageIndex, boolean engineMassIncludedInStageMass) {
		m_oModelCollection.elementAt(stageIndex).setEngineMassIncludedInStageMass(engineMassIncludedInStageMass);
		resetStageBurnTimes();
	}
	
	public void seperateStageByIndex(int stageIndex) {
		m_oModelCollection.elementAt(stageIndex).setIsSeperated(true);
		if(m_oModelCollection.elementAt(stageIndex).getIsMainStage()) {
			Iterator<Stage> stages = m_oModelCollection.iterator();
		    while(stages.hasNext()) {
		    	Stage stage = stages.next();
		    	stage.setIsSeperated(true);
		    }
		}
	}
	
	public void setCanAerobrakeAtDestinationByIndex(int stageIndex, boolean canAerobrakeAtDestination) {
		m_oModelCollection.elementAt(stageIndex).setCanAerobrakeAtDestination(canAerobrakeAtDestination);
		resetStageBurnTimes();
	}
	
	public void setCanLaunchAtDestinationByIndex(int stageIndex, boolean canLaunchAtDestination) {
		m_oModelCollection.elementAt(stageIndex).setCanLaunchAtDestination(canLaunchAtDestination);
		resetStageBurnTimes();
	}
	
	public void setCanLandAtDestinationByIndex(int stageIndex, boolean canLandAtDestination) {
		m_oModelCollection.elementAt(stageIndex).setCanLaunchAtDestination(canLandAtDestination);
		resetStageBurnTimes();
	}
	
	public void setIsReusableByIndex(int stageIndex, boolean isReusable) {
		m_oModelCollection.elementAt(stageIndex).setCanLaunchAtDestination(isReusable);
		resetStageBurnTimes();
	}
	
	public void resetAllStageGroupBurnTimes() {
		Iterator<Stage> stages = m_oModelCollection.iterator();
	    while(stages.hasNext()) {
	    	stages.next().resetBurnTime();
	    }
	}
			
	public void resetStageGroupBurnTimesByIndex() {
		Iterator<Stage> stages = m_oModelCollection.iterator();
	    while(stages.hasNext()) {
	    	stages.next().resetBurnTime();
	    }
	}
		
	public void partialBurnAllAttachedStagesByIndex(int stageGroupIndex, double burnTime) {
		Iterator<Stage> stages = m_oModelCollection.iterator();
	    while(stages.hasNext()) {
	    	Stage stage = stages.next();
	    	if(!stage.getIsSeperated()) {
	    		stage.partialBurn(burnTime);
	    	}
	    }
	}
	
	protected void performTasks() {
		resetStageBurnTimes();
		findMainStageIndex();
	}
	
	// Data members
	
	private static final long serialVersionUID = 1L;

	private double m_dPayloadMass;
	fairings
}
